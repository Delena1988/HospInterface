package com.lanniuh.reverse.service;

import com.lanniuh.reverse.model.Reverse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/13.
 */

public interface ReverseService {
    @Transactional(value = "reverse")
    List<Reverse> getReverse(Map<String, String> params);

    @Transactional(value = "bi")
    int firstVisit(Reverse reverse);

    @Transactional(value = "bi")
    String getVisitCardNo(String no);

}
