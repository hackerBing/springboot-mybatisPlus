package com.kt.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kt.demo.entity.Video;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper extends BaseMapper<Video> {





    /**
     * 查询视频详情
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);
}
