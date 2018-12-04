package com.hjw.book.mvp.model.entity;

import com.jess.arms.di.module.AppModule;

/**
 * @author hjw
 * 2018/11/29
 */
public class BookInfo {

    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 类别
     */
    private String type;

    /**
     * 状态
     */
    private String state;

    /**
     * 长度
     */
    private String length;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
