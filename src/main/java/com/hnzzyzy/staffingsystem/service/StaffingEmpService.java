package com.hnzzyzy.staffingsystem.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import com.hnzzyzy.staffingsystem.exception.InsertErrorException;
import com.hnzzyzy.staffingsystem.exception.UpdateErrorException;
import com.hnzzyzy.staffingsystem.exception.UserNameExitException;
import org.apache.ibatis.session.RowBounds;

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
     *
     * @param staffingEmp
     * @return
     */
    long getAllCount(StaffingEmp staffingEmp);

    StaffingEmp getEmpById(long empId);

    int insertEmp(StaffingEmp staffingEmp) throws UserNameExitException,InsertErrorException;


    int updateEmp(StaffingEmp staffingEmp) throws UpdateErrorException;
}
