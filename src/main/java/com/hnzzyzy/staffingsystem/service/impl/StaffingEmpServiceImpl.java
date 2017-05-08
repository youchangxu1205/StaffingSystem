package com.hnzzyzy.staffingsystem.service.impl;

import com.hnzzyzy.staffingsystem.dao.StaffingEmpMapper;
import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import com.hnzzyzy.staffingsystem.exception.InsertErrorException;
import com.hnzzyzy.staffingsystem.exception.UpdateErrorException;
import com.hnzzyzy.staffingsystem.exception.UserNameExitException;
import com.hnzzyzy.staffingsystem.service.StaffingEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dtkj_android on 2017/5/5.
 */
@Service
public class StaffingEmpServiceImpl implements StaffingEmpService {
    @Autowired
    StaffingEmpMapper staffingEmpMapper;

    public List<StaffingEmp> getEmpListByPage(Integer limit, Integer offset, String sortByOrder, StaffingEmp staffingEmp) {
        if (limit == null || limit == 0) {
            limit = 10;
        }

        if (offset == null) {
            offset = 0;
        }
        return staffingEmpMapper.queryEmpByPage(limit, offset, sortByOrder, staffingEmp);
    }

    @Override
    public long getAllCount(StaffingEmp staffingEmp) {
        return staffingEmpMapper.queryAllCount(staffingEmp);
    }

    public StaffingEmp getEmpById(long empId) {
        return staffingEmpMapper.queryEmpById(empId);
    }

    @Override
    public int insertEmp(StaffingEmp staffingEmp) throws UserNameExitException, InsertErrorException {
        StaffingEmp sqlEmp = staffingEmpMapper.queryEmpByUsername(staffingEmp.getUserName());
        if (sqlEmp != null) {
            throw new UserNameExitException("用户名已存在");
        }
        int count = staffingEmpMapper.insertEmp(staffingEmp);
        if (count == 0) {
            throw new InsertErrorException("保存失败");
        }
        return count;
    }

    @Override
    public int updateEmp(StaffingEmp staffingEmp) throws  UpdateErrorException {

        int count = staffingEmpMapper.updateEmp(staffingEmp);
        if (count == 0) {
            throw new UpdateErrorException("修改失败");
        }
        return count;
    }
}
