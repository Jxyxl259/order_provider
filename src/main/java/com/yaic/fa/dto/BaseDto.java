package com.yaic.fa.dto;

import java.io.Serializable;

import javax.persistence.Transient;

/**
 * 所有Dto的基类
 */
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 页数 */
    @Transient
    private int page;

    /** 每页条数 */
    @Transient
    private int rows;

    /** 排序的列 */
    @Transient
    private String sidx;

    /** 排序规则 */
    @Transient
    private String sord;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
