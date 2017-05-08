package com.hnzzyzy.staffingsystem.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.hnzzyzy.staffingsystem.dao.StaffingOrgMapper;
import com.hnzzyzy.staffingsystem.service.StaffingOrgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by xcy on 2017/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class StaffingOrgServiceImplTest {
    @Resource
    private StaffingOrgService staffingOrgService;

    @Test
    public void getOrgTree() throws Exception {
        JSONArray orgTree = staffingOrgService.getOrgTree(1L);
        System.out.println(orgTree);
    }

}