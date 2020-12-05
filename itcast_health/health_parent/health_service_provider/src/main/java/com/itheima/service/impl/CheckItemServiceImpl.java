package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * 检查项
 * */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    //添加检查项
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    //检查项分页查询
    @Override
    public PageResult PageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();//页码
        Integer pageSize = queryPageBean.getPageSize();//每页记录数
        String queryString = queryPageBean.getQueryString();//查询条件

        PageHelper.startPage(currentPage, pageSize);
        Page<CheckItem> page = checkItemDao.SelectByContion(queryString);
        List<CheckItem> rows = page.getResult();
        long total = page.getTotal();
        return new PageResult(total,rows);
    }
}
