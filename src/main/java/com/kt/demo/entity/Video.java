package com.kt.demo.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.beans.Transient;
import java.util.Date;
import java.util.List;

@Data
public class Video {

    private int id;

    private String title;

    private String summary;

    @JsonProperty("cover_img")
    private String coverImg;

    private int price;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


    private double point;

    @TableField(exist = false)
    @JsonProperty("chapter_list")
    private List<Chapter>chapterList;

}
