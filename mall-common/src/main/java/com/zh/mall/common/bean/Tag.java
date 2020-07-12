package com.zh.mall.common.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    private Integer id;
    private Integer pid;
    private String name;
    private boolean open = true;
    private String icon;
    private List<Tag> children = new ArrayList<Tag>();
}
