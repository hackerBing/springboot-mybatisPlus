package com.kt.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kt.demo.entity.Video;
import com.kt.demo.service.VideoService;
import com.kt.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pub/video")

public class VideoController {



    @Autowired
    private VideoService videoService;


    @RequestMapping("list")
    public JsonData listVideo(){
        QueryWrapper<Video> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(Video::getPoint).or().orderByDesc(Video::getPrice);
        List<Video> list = videoService.list(queryWrapper);

        return JsonData.buildSuccess(list);
    }

    /**
     * 查询视频详情，包含章，集信息
     * @param videoId
     * @return
     */

    @GetMapping("find_detail_by_id")
    public JsonData findDetailById(@RequestParam(value = "video_id",required = true)int videoId){


        Video video = videoService.findDetailById(videoId);

        return JsonData.buildSuccess(video);
    }


}
