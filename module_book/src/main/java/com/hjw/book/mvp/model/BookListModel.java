package com.hjw.book.mvp.model;

import com.hjw.book.mvp.model.api.service.BookService;
import com.hjw.book.mvp.model.entity.BookInfo;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * @author hjw
 * 2018/11/29
 */
public class BookListModel extends BaseModel implements BookListContract.Model{

    public BookListModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<List<BookInfo>> getBookInfoList() {
        return mRepositoryManager.obtainRetrofitService(BookService.class).getBookList();
    }
}
