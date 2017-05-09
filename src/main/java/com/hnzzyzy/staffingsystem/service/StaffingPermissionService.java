package com.hnzzyzy.staffingsystem.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hnzzyzy.staffingsystem.entity.StaffingPermission;

import java.util.List;

/**
 * Created by dtkj_android on 2017/5/9.
 */
public interface StaffingPermissionService {

    List<StaffingPermission> getPermissions(EntityWrapper<StaffingPermission> entityWrapper);

    int queryAllCount();
}
