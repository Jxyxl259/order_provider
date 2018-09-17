package com.yaic.fa.service;

import java.util.List;

import com.yaic.fa.dto.PageDto;
import com.yaic.fa.mybatis.mapper.entity.Condition;

public interface IBaseService<T> {

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param record
     * @return
     */
    public T selectByPrimaryKey(T record);

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record
     * @return
     */
    public T selectOne(T record);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record
     * @return
     */
    public List<T> select(T record);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，可排序
     * @param record
     * @param orderBy (如:id desc)
     * @return
     */
    public List<T> selectOrderBy(T record, String orderBy);

    /**
     * 根据Condition条件进行查询
     * @param condition
     * @return
     */
    public List<T> selectByCondition(Condition condition);

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record
     * @return
     */
    public int count(T record);

    /**
     * 根据Condition条件进行查询总数
     * @param condition
     * @return
     */
    public int count(Condition condition);

    /**
     * 根据实体属性作为条件进行删除，查询条件使用等号
     * @param record
     * @return
     */
    public int delete(T record);

    /**
     * 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @param record
     * @return
     */
    public int deleteByPrimaryKey(T record);

    /**
     * 根据Condition条件删除数据
     * @param condition
     * @return
     */
    public int deleteByCondition(Condition condition);

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record
     * @return
     */
    public int insert(T record);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param record
     * @return
     */
    public int insertNotNull(T record);

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record
     * @return
     */
    public int updateByPrimaryKey(T record);

    /**
     * 根据主键更新属性不为null的值
     * @param record
     * @return
     */
    public int updateByPrimaryKeyNotNull(T record);

    /**
     * 根据Condition条件更新实体`record`包含的全部属性，null值会被更新
     * @param record
     * @param condition
     * @return
     */
    public int updateByCondition(T record, Condition condition);

    /**
     * 根据Condition条件更新实体`record`包含的不是null的属性值
     * @param record
     * @param condition
     * @return
     */
    public int updateByConditionNotNull(T record, Condition condition);

    /**
     * 单表分页
     * @param pageNum 页码
     * @param pageSize 条数
     * @param record 条件实体
     * @return
     */
    public PageDto<T> selectByPage(PageDto<T> pageDto, T record);

    /**
     * 单表分页 可排序
     * @param pageNum 页码
     * @param pageSize 条数
     * @param record 条件实体
     * @param orderBy (如:id desc)
     * @return
     */
    public PageDto<T> selectByPage(PageDto<T> pageDto, T record, String orderBy);

    /**
     * 单表分页  根据Condition条件进行查询
     * @param pageNum 页码
     * @param pageSize 条数
     * @param condition 条件
     * @return
     */
    public PageDto<T> selectByPage(PageDto<T> pageDto, Condition condition);
}
