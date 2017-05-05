package com.hnzzyzy.staffingsystem.service.impl;

import com.hnzzyzy.staffingsystem.dao.StaffingEmpMapper;
import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
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
        return staffingEmpMapper.queryEmpByPage(limit, offset,sortByOrder, staffingEmp);
    }

    @Override
    public long getAllCount() {
        return staffingEmpMapper.queryAllCount();
    }

    public StaffingEmp getEmpById(long empId) {
        return staffingEmpMapper.queryEmpById(empId);
    }
}
