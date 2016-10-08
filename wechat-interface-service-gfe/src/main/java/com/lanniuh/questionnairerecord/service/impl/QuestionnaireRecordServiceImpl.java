package com.lanniuh.questionnairerecord.service.impl;

import com.lanniuh.questionnairerecord.dao.QuestionnaireRecordMapper;
import com.lanniuh.questionnairerecord.model.QuestionnaireRecord;
import com.lanniuh.questionnairerecord.service.QuestionnaireRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by linjian
 * 16/8/29.
 */
@Service("questionnaireRecordService")
public class QuestionnaireRecordServiceImpl implements QuestionnaireRecordService {
    @Resource
    private QuestionnaireRecordMapper questionnaireRecordMapper;

    @Override
    public int insert(QuestionnaireRecord questionnaireRecord) {
        return questionnaireRecordMapper.insert(questionnaireRecord);
    }
}
