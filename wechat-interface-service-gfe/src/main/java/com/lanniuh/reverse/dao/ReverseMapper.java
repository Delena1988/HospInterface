package com.lanniuh.reverse.dao;

import com.lanniuh.reverse.model.Reverse;

import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/13.
 */
public interface ReverseMapper {
    List<Reverse> getReverse(Map<String,String> params);
}
