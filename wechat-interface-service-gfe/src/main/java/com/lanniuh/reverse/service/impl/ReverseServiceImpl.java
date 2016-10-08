package com.lanniuh.reverse.service.impl;

import com.lanniuh.reverse.dao.ReverseMapper;
import com.lanniuh.reverse.model.Reverse;
import com.lanniuh.reverse.service.ReverseService;
import com.lanniuh.util.SpringContextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by linjian
 * 16/9/13.
 */
@Service("reverseService")
public class ReverseServiceImpl implements ReverseService {
    @Resource
    private ReverseMapper reverseMapper;

    @Override
    public List<Reverse> getReverse(Map<String, String> params) {
        return reverseMapper.getReverse(params);
    }

    @Override
    public int firstVisit(final Reverse reverse) {
        DataSource dataSource4 = SpringContextUtil.getBean("dataSource4");
        Connection conn = null;
        int res = 0;
        try {
            conn = dataSource4.getConnection();
            CallableStatement cs = conn.prepareCall("{call proc_ysf (?,?,?,?,?,?)}");
            cs.setString(1, reverse.getOrganCode());// 设置输入参数的值
            cs.setString(2, reverse.getPatName());
            cs.setString(3, reverse.getVisitCardNo());
            cs.setString(4, "");
            cs.setString(5, reverse.getIdNumber());
            cs.setString(6, reverse.getDeptCode());
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                res = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }


    @Override
    public String getVisitCardNo(String no) {
        DataSource dataSource4 = SpringContextUtil.getBean("dataSource4");
        Connection conn = null;
        try {
            conn = dataSource4.getConnection();
            CallableStatement cs = conn.prepareCall("{call proc_getcard (?)}");
            cs.setString(1, no);// 设置输入参数的值

            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                no = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return no;
    }
}
