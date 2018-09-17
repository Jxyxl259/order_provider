package com.yaic.app.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author zhujuan From: https://github.com/twitter/snowflake An object that generates IDs. This is broken into a
 *         separate class in case we ever want to support multiple worker threads per process
 */
public class IdWorker
{
	private static final Logger LOG = LoggerFactory.getLogger(IdWorker.class);

	private final long workerId;
	private final long datacenterId;

	private long lastTimestamp = -1L;
	private long sequence = 0L;

	private final long twepoch = 1288834974657L;
	private final long workerIdBits = 5L;
	private final long datacenterIdBits = 5L;
	private final long sequenceBits = 12L;

	private final long maxWorkerId = -1L ^ (-1L << workerIdBits);
	private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
	private final long workerIdShift = sequenceBits;
	private final long datacenterIdShift = sequenceBits + workerIdBits;
	private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
	private final long sequenceMask = -1L ^ (-1L << sequenceBits);

	/**
	 * machine id—10bits,该部分其实由datacenterId和workerId两部分组成，这两部分是在配置文件中指明的。
	 *
	 * <pre>
	 * datacenterId的作用：
	 * <p>
	 * 1.方便搭建多个生成uid的service，并保证uid不重复，比如在datacenter0将机器0，1，2组成了一个生成uid的service，
	 * 而datacenter1此时也需要一个生成uid的service，从本中心获取uid显然是最快最方便的，那么它可以在自己中心搭建，
	 * 只要保证datacenterId唯一。如果没有datacenterId，即用10bits，那么在搭建一个新的service前必须知道目前已经在用的id， 否则不能保证生成的id唯一，比如搭建的两个uid
	 * service中都有machine id为100的机器，如果其server时间相同， 那么产生相同id的情况不可避免。
	 * <p>
	 * 2.加快server启动速度。启动一台uid server时，会去检查zk同workerId目录中其他机器的情况， 如其在zk上注册的id和向它请求返回的work_id是否相同，是否处同一个datacenter下，
	 * 另外还会检查该server的时间与目前已有机器的平均时间误差是否在10s范围内等， 这些检查是会耗费一定时间的。将一个datacenter下的机器数限制在32台(5bits)以内， 在一定程度上也保证了server的启动速度。
	 *
	 * <pre>
	 * workerId的作用：
	 * <p>
	 * workerId是实际server机器的代号，最大到32，同一个datacenter下的workerId是不能重复的。
	 * <p>
	 * 它会被注册到zookeeper上，确保workerId未被其他机器占用，并将host:port值存入，注册成功后就可以对外提供服务了。
	 *
	 * @param workerId
	 * @param datacenterId
	 */
	public IdWorker(final long workerId, final long datacenterId)
	{
		if (workerId > maxWorkerId || workerId < 0)
		{
			throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}

		if (datacenterId > maxDatacenterId || datacenterId < 0)
		{
			throw new IllegalArgumentException(
					String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
		}

		LOG.info(
				"worker starting. timestamp left shift {}, datacenter id bits {}, worker id bits {}, sequence bits {}, workerid {}",
				timestampLeftShift, datacenterIdBits, workerIdBits, sequenceBits, workerId);

		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	/**
	 * @return ID
	 */
	protected synchronized long nextId()
	{
		long timestamp = timeGen();

		if (timestamp < lastTimestamp)
		{
			LOG.error("clock is moving backwards.  Rejecting requests until {}.", lastTimestamp);
			throw new RuntimeException(
					String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp)
		{
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0)
			{
				timestamp = tilNextMillis(lastTimestamp);
			}
		}
		else
		{
			sequence = 0L;
		}

		lastTimestamp = timestamp;

		return ((timestamp - twepoch) << timestampLeftShift) | (datacenterId << datacenterIdShift) | (workerId << workerIdShift)
				| sequence;
	}

	private long tilNextMillis(final long lastTimestamp)
	{
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp)
		{
			timestamp = timeGen();
		}
		return timestamp;
	}

	private long timeGen()
	{
		return System.currentTimeMillis();
	}
}
