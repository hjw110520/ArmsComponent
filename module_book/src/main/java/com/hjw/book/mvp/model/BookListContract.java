package com.hjw.book.mvp.model;

import com.hjw.book.mvp.model.entity.BookInfo;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author hjw
 * 2018/11/29
 */
public interface BookListContract {

    /**
     * 对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
     */
    interface View extends IView{

    }

    /**
     * Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,如是否使用缓存
     */
    interface Model extends IModel{
        /**
         * 获取书籍信息列表
         * @return 书籍列表
         */
        Observable<List<BookInfo>> getBookInfoList();
    }

}
