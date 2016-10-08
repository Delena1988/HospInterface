package com.lanniuh.checkinreminder.dao;

import com.lanniuh.checkinreminder.model.CheckInReminder;

import java.util.List;
import java.util.Map;

public interface CheckInReminderMapper {
    List<CheckInReminder> getCheckedPatient(Map<String,String> params);
}