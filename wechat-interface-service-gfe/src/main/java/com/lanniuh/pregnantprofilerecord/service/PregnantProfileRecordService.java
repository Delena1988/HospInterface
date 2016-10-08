package com.lanniuh.pregnantprofilerecord.service;

import com.lanniuh.pregnantprofilerecord.model.PregnantProfileRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linjian
 * 16/9/18.
 */
@Transactional("interview")
public interface PregnantProfileRecordService {
    int insert(PregnantProfileRecord pregnantProfileRecord);
}
