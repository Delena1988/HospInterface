package com.lanniuh.checkinreminder.service.impl;

import com.lanniuh.checkinreminder.dao.CheckInReminderMapper;
import com.lanniuh.checkinreminder.model.CheckInReminder;
import com.lanniuh.checkinreminder.service.CheckInReminderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/8.
 */
@Service("checkInReminderService")
public class CheckInReminderServiceImpl implements CheckInReminderService {
    @Resource
    private CheckInReminderMapper checkInReminderMapper;
    @Override
    public List<CheckInReminder> getCheckedPatient(Map<String,String> params) {
        return checkInReminderMapper.getCheckedPatient(params);
    }
}
