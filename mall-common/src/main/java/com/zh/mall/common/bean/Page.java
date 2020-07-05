package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private List<T> datas;
    private int totalsize;
    private int totalno;
    private int pageno;
    private int pagesize;
}
