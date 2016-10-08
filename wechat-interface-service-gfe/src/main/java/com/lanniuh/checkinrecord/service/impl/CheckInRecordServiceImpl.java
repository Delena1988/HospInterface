package com.lanniuh.checkinrecord.service.impl;

import com.lanniuh.checkinrecord.dao.CheckInRecordMapper;
import com.lanniuh.checkinrecord.model.CheckInRecord;
import com.lanniuh.checkinrecord.service.CheckInRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by linjian
 * 16/9/8.
 */
@Service("checkInRecordService")
public class CheckInRecordServiceImpl implements CheckInRecordService {
    @Resource
    private CheckInRecordMapper checkInRecordMapper;

    @Override
    public int insert(CheckInRecord checkInRecord) {
        return checkInRecordMapper.insert(checkInRecord);
    }
}
