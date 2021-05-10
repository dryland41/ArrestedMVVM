
package com.example;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Jail {

    @com.squareup.moshi.Json(name = "city")
    public String city;
    @com.squareup.moshi.Json(name = "name")
    public String name;
    @com.squareup.moshi.Json(name = "url")
    public String url;
    @com.squareup.moshi.Json(name = "address1")
    public String address1;
    @com.squareup.moshi.Json(name = "address2")
    public String address2;
    @com.squareup.moshi.Json(name = "state")
    public String state;

    public Jail withCity(String city) {
        this.city = city;
        return this;
    }

    public Jail withName(String name) {
        this.name = name;
        return this;
    }

    public Jail withUrl(String url) {
        this.url = url;
        return this;
    }

    public Jail withAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public Jail withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public Jail withState(String state) {
        this.state = state;
        return this;
    }

}
