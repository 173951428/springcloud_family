package com.springcloud.product_service.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 *
 * @author
 */
@Data
public class User implements Serializable {
    private Long id;

    private String name;

    private String age;

    private static final long serialVersionUID = 1L;

}