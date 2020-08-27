package com.kt.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.kt.demo.entity.Video;


public interface VideoService  extends IService<Video> {

    Video findDetailById(int videoId);

}
