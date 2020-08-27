package com.kt.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kt.demo.entity.VideoOrder;

import java.util.Map;

public interface VideoOrderService extends IService<VideoOrder> {

    boolean add(int userId,  int videoId);
}
