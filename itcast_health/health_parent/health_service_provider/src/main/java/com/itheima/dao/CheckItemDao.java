package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> SelectByContion(String queryString);
}
