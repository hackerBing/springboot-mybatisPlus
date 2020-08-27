package com.kt.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kt.demo.entity.User;

import java.util.Map;

public interface UserService extends IService<User> {
    boolean saves(Map<String ,String > userInfo);
}
