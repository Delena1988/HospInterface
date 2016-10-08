package com.lanniuh.referralreminderrecord.service;

import com.lanniuh.referralreminderrecord.model.ReferralReminderRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linjian
 * 16/8/31.
 */
@Transactional(value = "interview")
public interface ReferralReminderRecordService {
    int insert(ReferralReminderRecord referralReminderRecord);
}
