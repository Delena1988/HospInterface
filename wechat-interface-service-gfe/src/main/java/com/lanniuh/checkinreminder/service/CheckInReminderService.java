package com.lanniuh.checkinreminder.service;

import com.lanniuh.checkinreminder.model.CheckInReminder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/8.
 */
@Transactional(value = "angel")
public interface CheckInReminderService {
    List<CheckInReminder> getCheckedPatient(Map<String,String> params);
}
