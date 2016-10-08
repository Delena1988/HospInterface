package com.lanniuh.pregnantprofile.dao;

import com.lanniuh.pregnantprofile.model.PregnantProfile;
import com.lanniuh.pregnantprofile.model.SelfPregnantInfo;

import java.util.List;
import java.util.Map;

public interface PregnantProfileMapper {
    List<PregnantProfile> getPregnantProfile(Map<String,String> params);
    List<SelfPregnantInfo> getSelfPregnantInfo(Map<String,String> params);
}