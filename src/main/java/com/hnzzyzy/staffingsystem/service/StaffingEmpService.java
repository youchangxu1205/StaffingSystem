package com.hnzzyzy.staffingsystem.service;

import com.hnzzyzy.staffingsystem.entity.StaffingEmp;

import java.util.List;

/**
 * Created by dtkj_android on 2017/5/5.
 */
public interface StaffingEmpService {
    /**
     * 获取员工列表
     *
     * @param limit
     * @param offset
     * @param sortByOrder
     * @return
     */
    List<StaffingEmp> getEmpListByPage(Integer limit, Integer offset, String sortByOrder, StaffingEmp staffingEmp);

    /**
     * 获取个数
     * @return
     */
    long getAllCount();

    StaffingEmp getEmpById(long empId);


}
