package com.kt.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kt.demo.entity.PlayRecord;
import com.kt.demo.mapper.PlayRecordMapper;
import com.kt.demo.service.PlayRecordService;
import org.springframework.stereotype.Service;

@Service
public class PlayRecordServiceImpl extends ServiceImpl<PlayRecordMapper, PlayRecord> implements PlayRecordService {

}
