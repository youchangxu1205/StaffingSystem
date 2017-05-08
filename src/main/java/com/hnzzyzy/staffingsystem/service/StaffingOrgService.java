package com.hnzzyzy.staffingsystem.service;

import com.alibaba.fastjson.JSONArray;
import com.hnzzyzy.staffingsystem.entity.StaffingOrg;

import java.util.List;

/**
 * Created by xcy on 2017/5/7.
 */
public interface StaffingOrgService {
    /**
     * 获取部门树
     * @param orgId
     * @return
     */
    JSONArray getOrgTree(Long orgId);

    /**
     * 获取部门详情
     * @param orgId
     * @return
     */
    StaffingOrg getOrgById(Long orgId);

    /**
     * 获取下级部门
     * @param orgId
     * @return
     */
    List<StaffingOrg> getChildOrgById(Long orgId);

    List<StaffingOrg> getOrgListByPage(int limit, int offset, String sortByOrder, StaffingOrg staffingOrg);

    long getAllCount(StaffingOrg staffingOrg);
}
