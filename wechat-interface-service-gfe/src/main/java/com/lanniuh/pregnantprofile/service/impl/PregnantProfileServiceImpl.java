package com.lanniuh.pregnantprofile.service.impl;

import com.lanniuh.pregnantprofile.dao.PregnantProfileMapper;
import com.lanniuh.pregnantprofile.model.PregnantProfile;
import com.lanniuh.pregnantprofile.model.SelfPregnantInfo;
import com.lanniuh.pregnantprofile.service.PregnantProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/13.
 */
@Service("pregnantProfileService")
public class PregnantProfileServiceImpl implements PregnantProfileService {
    @Resource
    private PregnantProfileMapper pregnantProfileMapper;

    @Override
    public List<PregnantProfile> getPregnantProfile(Map<String, String> params) {
        return pregnantProfileMapper.getPregnantProfile(params);
    }

    @Override
    public List<SelfPregnantInfo> getSelfPregnantInfo(Map<String, String> params) {
        return pregnantProfileMapper.getSelfPregnantInfo(params);
    }
}
