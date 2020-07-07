package com.zh.mall.common.bean;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class Datas {
    private List<Integer> ids;
    private List<GoodsCategory> gcs;

    public List<GoodsCategory> getGcs() {
        return gcs;
    }

    public void setGcs(List<GoodsCategory> gcs) {
        this.gcs = gcs;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
