package com.kt.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
@TableName("video_banner")
public class Banner {

    private Integer id;

    private String url;

    private String img;
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyy-mm-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer weight;

}
