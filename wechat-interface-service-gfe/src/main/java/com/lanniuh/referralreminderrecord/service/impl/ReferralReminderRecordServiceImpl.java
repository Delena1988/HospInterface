package com.lanniuh.referralreminderrecord.service.impl;

import com.lanniuh.referralreminderrecord.dao.ReferralReminderRecordMapper;
import com.lanniuh.referralreminderrecord.model.ReferralReminderRecord;
import com.lanniuh.referralreminderrecord.service.ReferralReminderRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by linjian
 * 16/8/31.
 */
@Service("referralReminderRecordService")
public class ReferralReminderRecordServiceImpl implements ReferralReminderRecordService {
    @Resource
    private ReferralReminderRecordMapper referralReminderRecordMapper;
    @Override
    public int insert(ReferralReminderRecord referralReminderRecord) {
        return referralReminderRecordMapper.insert(referralReminderRecord);
    }
}
