package com.hjw.book.mvp.model.entity;

/**
 * @author hjw
 * 2018/12/3
 */
public class Page {
    /**
     * 下标起始位置
     */
    private int startPos;

    /**
     * 下标结束位置
     */
    private int endPos;
    /**
     * 本页数量
     */
    private int count;

    /**
     * 总数量
     */
    private int totalNum;

    /**
     * 总页数
     */
    private int tatalPage;

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getTatalPage() {
        return tatalPage;
    }

    public void setTatalPage(int tatalPage) {
        this.tatalPage = tatalPage;
    }
}
