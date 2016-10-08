package com.lanniuh.order.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Order implements Serializable {
    private static final long serialVersionUID = -2115889085566674313L;
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}