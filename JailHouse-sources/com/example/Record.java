
package com.example;

import java.util.List;
import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Record {

    @com.squareup.moshi.Json(name = "book_date_formatted")
    public String bookDateFormatted;
    @com.squareup.moshi.Json(name = "name")
    public String name;
    @com.squareup.moshi.Json(name = "mugshot")
    public String mugshot;
    @com.squareup.moshi.Json(name = "book_date")
    public String bookDate;
    @com.squareup.moshi.Json(name = "charges")
    public List<String> charges = null;
    @com.squareup.moshi.Json(name = "id")
    public Integer id;
    @com.squareup.moshi.Json(name = "more_info_url")
    public String moreInfoUrl;

    public Record withBookDateFormatted(String bookDateFormatted) {
        this.bookDateFormatted = bookDateFormatted;
        return this;
    }

    public Record withName(String name) {
        this.name = name;
        return this;
    }

    public Record withMugshot(String mugshot) {
        this.mugshot = mugshot;
        return this;
    }

    public Record withBookDate(String bookDate) {
        this.bookDate = bookDate;
        return this;
    }

    public Record withCharges(List<String> charges) {
        this.charges = charges;
        return this;
    }

    public Record withId(Integer id) {
        this.id = id;
        return this;
    }

    public Record withMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
        return this;
    }

}
