package com.example.masterdetailflowdemo.dummy;

import java.util.List;

public class Users {
    private String page;
    private String per_page;
    private String total;
    private String total_pages;
    private List<Data> data;

    public String getPage() {
        return page;
    }

    public String getPer_page() {
        return per_page;
    }

    public String getTotal() {
        return total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public Users(String page, String per_page, String total, String total_pages, List<Data> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }
}
