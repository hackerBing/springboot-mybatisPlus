package com.kt.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kt.demo.entity.Episode;
import com.kt.demo.mapper.EpisodeMapper;
import com.kt.demo.service.EpisodeService;
import org.springframework.stereotype.Service;


@Service
public class EpisodeServiceImpl extends ServiceImpl<EpisodeMapper,Episode>  implements EpisodeService {
}
