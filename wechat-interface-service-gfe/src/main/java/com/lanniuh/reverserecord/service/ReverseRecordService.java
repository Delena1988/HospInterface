package com.lanniuh.reverserecord.service;

import com.lanniuh.reverserecord.model.ReverseRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linjian
 * 16/9/23.
 */
@Transactional(value = "interview")
public interface ReverseRecordService {
    int insert(ReverseRecord reverseRecord);
}
