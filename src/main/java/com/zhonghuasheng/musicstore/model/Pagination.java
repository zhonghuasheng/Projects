package com.zhonghuasheng.musicstore.model;

import java.util.List;

public class Pagination {

    private int currentPage;
    private int totalPage;
    private String key;
    private List<? extends BaseModel> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<? extends BaseModel> getData() {
        return data;
    }

    public void setData(List<? extends BaseModel> data) {
        this.data = data;
    }
}
