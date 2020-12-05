package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult PageQuery(QueryPageBean queryPageBean);
}
