package com.lanniuh.pregnantprofilerecord.service.impl;

import com.lanniuh.pregnantprofilerecord.dao.PregnantProfileRecordMapper;
import com.lanniuh.pregnantprofilerecord.model.PregnantProfileRecord;
import com.lanniuh.pregnantprofilerecord.service.PregnantProfileRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by linjian
 * 16/9/18.
 */
@Service("pregnantProfileRecordService")
public class PregnantProfileRecordServiceImpl implements PregnantProfileRecordService{
    @Resource
    private PregnantProfileRecordMapper pregnantProfileRecordMapper;
    @Override
    public int insert(PregnantProfileRecord pregnantProfileRecord) {
        return pregnantProfileRecordMapper.insert(pregnantProfileRecord);
    }
}
