package com.lanniuh.pregnantprofile.service;

import com.lanniuh.pregnantprofile.model.PregnantProfile;
import com.lanniuh.pregnantprofile.model.SelfPregnantInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/13.
 */
@Transactional(value = "interview")
public interface PregnantProfileService {
    List<PregnantProfile> getPregnantProfile(Map<String, String> params);
    List<SelfPregnantInfo> getSelfPregnantInfo(Map<String, String> params);
}
