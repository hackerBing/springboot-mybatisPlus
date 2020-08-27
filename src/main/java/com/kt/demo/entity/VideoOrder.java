package com.kt.demo.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class VideoOrder {

    private int id;

    @JsonProperty("out_trade_no")
    private String outTradeNo;

    private Integer state;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonProperty("total_fee")
    private Integer totalFee;

    @JsonProperty("video_id")
    private Integer videoId;

    @JsonProperty("video_title")
    private String videoTitle;

    @JsonProperty("video_img")
    private String videoImg;

    @JsonProperty("user_id")
    private  Integer userId;

}
