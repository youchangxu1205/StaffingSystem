package com.hnzzyzy.staffingsystem.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.hnzzyzy.staffingsystem.dao.StaffingPermissionMapper;
import com.hnzzyzy.staffingsystem.entity.StaffingPermission;
import com.hnzzyzy.staffingsystem.service.StaffingPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dtkj_android on 2017/5/9.
 */
@Service
public class StaffingPermissionServiceImpl implements StaffingPermissionService {
    @Autowired
    private StaffingPermissionMapper staffingPermissionMapper;

    @Override
    public List<StaffingPermission> getPermissions() {

        return staffingPermissionMapper.selectList(new EntityWrapper<StaffingPermission>());
    }

    @Override
    public int queryAllCount() {
        Integer c = staffingPermissionMapper.selectCount(new EntityWrapper<StaffingPermission>());
        return c;
    }
}
