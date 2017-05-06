package com.hnzzyzy.staffingsystem.dao;

import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 员工
 * Created by dtkj_android on 2017/5/5.
 */
public interface StaffingEmpMapper {
    /**
     * 分页查询员工
     *
     * @param limit
     * @param offset
     * @param sortByOrder
     * @param staffingEmp //根据条件查询员工信息  @return
     */
    List<StaffingEmp> queryEmpByPage(@Param("limit") int limit, @Param("offset") int offset, @Param("sortByOrder") String sortByOrder, @Param("staffingEmp") StaffingEmp staffingEmp);

    /**
     * 根据主键查询员工信息
     *
     * @param empId
     * @return
     */
    StaffingEmp queryEmpById(long empId);

    /**
     * 保存用户信息
     *
     * @param staffingEmp
     * @return
     */
    int insertEmp(StaffingEmp staffingEmp);

    /**
     * 更新用户信息 传递什么更新什么
     *
     * @param staffingEmp
     * @return
     */
    int updateEmp(StaffingEmp staffingEmp);

    /**
     * 查询总共的条数
     *
     * @return
     * @param staffingEmp
     */
    long queryAllCount(StaffingEmp staffingEmp);
}
