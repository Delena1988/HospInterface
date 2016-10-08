package com.lanniuh.checkinrecord.service;

import com.lanniuh.checkinrecord.model.CheckInRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linjian
 * 16/9/8.
 */
@Transactional(value = "interview")
public interface CheckInRecordService {
    int insert(CheckInRecord checkInRecord);
}
