package com.kt.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kt.demo.entity.Video;
import com.kt.demo.entity.VideoOrder;
import com.kt.demo.service.VideoOrderService;
import com.kt.demo.service.VideoService;
import com.kt.demo.utils.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {


    @Resource
    private VideoOrderService videoOrderService;

    @Resource
    private VideoService videoService;

    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody(required = false)Map<String ,String > data, HttpServletRequest request) {

        Integer videoId = Integer.valueOf(data.get("video_id"));
        Integer userId = (Integer) request.getAttribute("user_id");


        QueryWrapper<VideoOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(VideoOrder::getUserId,userId).eq(VideoOrder::getVideoId,videoId);

        VideoOrder videoOrder = videoOrderService.getOne(queryWrapper);
        if(videoOrder != null){
            return  JsonData.buildError("已经购买，无需重复购买");
        }

        Video video = videoService.getById(videoId);
        if(video == null){
            return JsonData.buildError("视频不存在");
        }



        boolean result = videoOrderService.add(userId,videoId);

        return result == false ? JsonData.buildError("下单失败") : JsonData.buildSuccess();
    }

    @GetMapping("list")
    public JsonData listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        QueryWrapper<VideoOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(VideoOrder::getUserId,userId);
        List<VideoOrder> videoOrderList = videoOrderService.getBaseMapper().selectList(queryWrapper);

        return JsonData.buildSuccess(videoOrderList);

    }
}
