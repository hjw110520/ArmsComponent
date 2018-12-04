package com.hjw.book.mvp.model.entity.response.base;

/**
 * @author hjw
 * 2018/12/3
 * @param <T> This describes my type parameter
 */
public class BaseEntityResponse<T> extends BaseResponse{

    /**
     * 返回的数据
    */
    private T data;
}
