package com.hnzzyzy.staffingsystem.dao;

import com.hnzzyzy.staffingsystem.entity.StaffingOrg;

import java.util.List;

/**
 * Created by xcy on 2017/5/7.
 */
public interface StaffingOrgMapper {

    /**
     * 根据主键查询ID
     * @param orgId
     * @return
     */
    StaffingOrg queryOrgById(long orgId);

    /**
     * 查询下级部门ID
     * @param orgId
     * @return
     */
    List<StaffingOrg> queryChildOrgById(long orgId);


}
