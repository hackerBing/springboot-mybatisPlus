package com.kt.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kt.demo.entity.User;
import com.kt.demo.service.UserService;
import com.kt.demo.utils.CommonUtils;
import com.kt.demo.utils.JWTUtils;
import com.kt.demo.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class  UserController{


    @Autowired
    private UserService userService;





    @PostMapping("register")
    public JsonData register(@RequestBody Map<String ,String > userInfo){
        boolean row = userService.saves(userInfo);

        return row == true ? JsonData.buildSuccess() : JsonData.buildError("注册失败，请重试");
    }

    @PostMapping("login")
    public  JsonData login(@RequestBody Map<String ,String > data){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getPhone,data.get("phone")).eq(User::getPwd, CommonUtils.MD5(data.get("pwd")));

        User user = userService.getOne(queryWrapper);

        if(user == null){
            return JsonData.buildError("登录失败！");
        }
        String token = JWTUtils.geneJsonWebToken(user);
        return JsonData.buildSuccess(token);
    }

    @GetMapping("/test")
    public JsonData testId(HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");

        if(userId == null){
            return JsonData.buildError("查询失败");
        }

        return JsonData.buildSuccess( userId);
    }

    @GetMapping("find_by_token")
    public JsonData getUser(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        if(userId == null){
            return JsonData.buildError("查询失败");
        }
        User user = userService.getById(userId);
        return JsonData.buildSuccess(user);
    }

}
