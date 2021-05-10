
package com.example;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class JailHouse {

    @com.squareup.moshi.Json(name = "status")
    public Integer status;
    @com.squareup.moshi.Json(name = "next_page")
    public Integer nextPage;
    @com.squareup.moshi.Json(name = "records")
    public List<Record> records = null;
    @com.squareup.moshi.Json(name = "current_page")
    public Integer currentPage;
    @com.squareup.moshi.Json(name = "total_records")
    public Integer totalRecords;
    @com.squareup.moshi.Json(name = "jail")
    public Jail jail;
    @com.squareup.moshi.Json(name = "msg")
    public String msg;

    public JailHouse withStatus(Integer status) {
        this.status = status;
        return this;
    }

    public JailHouse withNextPage(Integer nextPage) {
        this.nextPage = nextPage;
        return this;
    }

    public JailHouse withRecords(List<Record> records) {
        this.records = records;
        return this;
    }

    public JailHouse withCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        return this;
    }

    public JailHouse withTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        return this;
    }

    public JailHouse withJail(Jail jail) {
        this.jail = jail;
        return this;
    }

    public JailHouse withMsg(String msg) {
        this.msg = msg;
        return this;
    }

}
