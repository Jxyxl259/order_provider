package com.yaic.app.epolicy.dto.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class EpolicyAvgpremDto {

	/** 投保份数 */
	@XStreamAlias("UWCOUNT")
	private String uwCount;
	
	/** 每份保额 */
	@XStreamAlias("AVSUMINSURED")
	private String avsumInsured;
	
	/** 每份保费 */
	@XStreamAlias("AVGPREMIUM")
	private String avgPremium;

	/** 投保份数 */
	public String getUwCount() {
		return uwCount;
	}

	/** 投保份数 */
	public void setUwCount(String uwCount) {
		this.uwCount = uwCount;
	}

	/** 每份保额 */
	public String getAvsumInsured() {
		return avsumInsured;
	}

	/** 每份保额 */
	public void setAvsumInsured(String avsumInsured) {
		this.avsumInsured = avsumInsured;
	}

	/** 每份保费 */
	public String getAvgPremium() {
		return avgPremium;
	}

	/** 每份保费 */
	public void setAvgPremium(String avgPremium) {
		this.avgPremium = avgPremium;
	}

}
