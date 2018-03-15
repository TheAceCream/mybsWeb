package com.mybs.utils;

import java.io.Serializable;

/**
 * Created by AceCream on 2018/3/15.
 */
public class Pager implements Serializable{

    private int pageSize = 10;

    private int pageNo = 1;

    private int start = 0;

    private int totalRows = 0;

    private int pageCount = 0;

    Object obj = null;

    public Pager() {
    }

    public Pager(int pageSize, int pageNo) {
        if (pageSize!=0){
            this.pageSize = pageSize;
        }
        if (pageNo != 0){
            this.pageNo = pageNo;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        this.pageCount = getTotalRows() % getPageSize() == 0 ? getTotalRows()/getPageSize():getTotalRows()/getPageSize()+1;
    }

    public int getPageCount() {
        return getTotalRows()%getPageSize()==0?getTotalRows()/getPageSize():getTotalRows()/getPageSize()+1;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", start=" + start +
                ", totalRows=" + totalRows +
                ", pageCount=" + pageCount +
                ", obj=" + obj +
                '}';
    }
}
