package com.hnzzyzy.staffingsystem.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hnzzyzy.staffingsystem.entity.StaffingOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xcy on 2017/5/7.
 */
public interface StaffingOrgMapper extends BaseMapper<StaffingOrg> {

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


    List<StaffingOrg> queryOrgByPage(@Param("limit") int limit, @Param("offset") int offset, @Param("sortByOrder") String sortByOrder, @Param("staffingOrg") StaffingOrg staffingOrg);

    long queryCount(StaffingOrg staffingOrg);
}
