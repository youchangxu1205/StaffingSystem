package com.hnzzyzy.staffingsystem.dao;

import com.hnzzyzy.staffingsystem.entity.StaffingOrg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xcy on 2017/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StaffingOrgMapperTest {
    @Resource
    StaffingOrgMapper staffingOrgMapper;
    @Test
    public void queryOrgById() throws Exception {
        StaffingOrg staffingOrg = staffingOrgMapper.queryOrgById(1);
        System.out.println(staffingOrg);
    }

    @Test
    public void queryChildOrgById() throws Exception {
        List<StaffingOrg> staffingOrgList = staffingOrgMapper.queryChildOrgById(1);
        for (StaffingOrg staffingOrg :
                staffingOrgList) {
           System.out.println(staffingOrg);
        }
    }

}