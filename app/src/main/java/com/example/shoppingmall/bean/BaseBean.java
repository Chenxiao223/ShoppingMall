package com.example.shoppingmall.bean;

import java.io.Serializable;

/**
 * Created by Ivan on 15/9/24.
 */
//首页展示通过id寻找
public class BaseBean implements Serializable {


    protected   long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
