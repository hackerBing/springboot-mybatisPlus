package com.kt.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kt.demo.entity.Banner;
import com.kt.demo.service.BannerService;
import com.kt.demo.service.VideoService;
import com.kt.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class BannerController {


    @Autowired
    private BannerService bannerService;

    @GetMapping("list_banner")
    public JsonData listBanner(){

        QueryWrapper<Banner> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByAsc(Banner::getWeight);

        List<Banner> bannerList = bannerService.list(queryWrapper);
        return JsonData.buildSuccess(bannerList);
    }
}
