package com.lanniuh.reverserecord.service.impl;

import com.lanniuh.reverserecord.dao.ReverseRecordMapper;
import com.lanniuh.reverserecord.model.ReverseRecord;
import com.lanniuh.reverserecord.service.ReverseRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by linjian
 * 16/9/23.
 */
@Service("reverseRecordService")
public class ReverseRecordServiceImpl implements ReverseRecordService {
    @Resource
    private ReverseRecordMapper reverseRecordMapper;

    @Override
    public int insert(ReverseRecord reverseRecord) {
        return reverseRecordMapper.insert(reverseRecord);
    }
}
