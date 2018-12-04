package com.hjw.book.mvp.model.entity.response.base;

import com.hjw.book.mvp.model.entity.Page;

import java.util.List;

/**
 * @author hjw
 * 2018/12/3
 * @param <T> This describes my type parameter
 */
public class BaseListResponse<T> extends BaseResponse{

    /**
     * 返回的页码信息
     */
    private Page pageBean;

    /**
     * 返回的数据
     */
    private List<T> data;
}
