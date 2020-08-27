package com.kt.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kt.demo.entity.Video;

import com.kt.demo.mapper.VideoMapper;
import com.kt.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService{


    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Video findDetailById(int videoId) {


        Video video = videoMapper.findDetailById(videoId);

        return video;
    }
}
