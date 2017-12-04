/*
 * 文件名：DeptService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Cheer
 * 修改时间：2017年11月28日
 */

package com.cheer.service;

import java.util.List;

import com.cheer.domain.Dept;
import com.cheer.util.Page;



public interface DeptService
{
    void save(Dept dept);

    void batchSave(List<Dept> depts);
    
    void delete(Dept dept);
    
    void update(Dept dept);
    
    Dept find(Integer deptno);
    
    List<Dept> getAll();

    List<Dept> getPage(Page page);
}
