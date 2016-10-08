package com.lanniuh.questionnairerecord.service;

import com.lanniuh.questionnairerecord.model.QuestionnaireRecord;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linjian
 * 16/8/29.
 */
@Transactional(value = "interview" )
public interface QuestionnaireRecordService {
    int insert(QuestionnaireRecord questionnaireRecord);
}
