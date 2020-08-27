package com.kt.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kt.demo.entity.Episode;
import com.kt.demo.entity.PlayRecord;
import com.kt.demo.entity.Video;
import com.kt.demo.entity.VideoOrder;
import com.kt.demo.mapper.VideoOrderMapper;
import com.kt.demo.service.EpisodeService;
import com.kt.demo.service.PlayRecordService;
import com.kt.demo.service.VideoOrderService;
import com.kt.demo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl extends ServiceImpl<VideoOrderMapper, VideoOrder> implements VideoOrderService {


    @Resource
    private VideoService videoService;

    @Resource
    private EpisodeService episodeService;

    @Resource
    private  PlayRecordService playRecordService;


    @Override
    public boolean add(int userId, int videoId) {

        Video video = videoService.getById(videoId);


        VideoOrder videoOrder = new VideoOrder();

        videoOrder.setCreateTime(new Date());
        videoOrder.setState(1);
        videoOrder.setTotalFee(video.getPrice());
        videoOrder.setVideoId(videoId);
        videoOrder.setVideoTitle(video.getTitle());
        videoOrder.setUserId(userId);
        videoOrder.setVideoImg(video.getCoverImg());
        videoOrder.setOutTradeNo(UUID.randomUUID().toString());

        boolean result = this.save(videoOrder);



        if(result){
//            Episode episode = episodeService.getById(videoId);
            QueryWrapper<Episode> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(Episode::getVideoId,videoId).eq(Episode::getNum,1);
            Episode episode = episodeService.getBaseMapper().selectOne(queryWrapper);
            if( episode == null ){
                return false;
            }

            PlayRecord playRecord = new PlayRecord();
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCreateTime(new Date());

//            playRecordService.save(playRecord);


        }

        return true;



    }
}
