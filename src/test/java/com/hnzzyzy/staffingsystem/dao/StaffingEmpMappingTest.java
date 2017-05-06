package com.hnzzyzy.staffingsystem.dao;

import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by dtkj_android on 2017/5/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StaffingEmpMappingTest {
    @Resource
    private StaffingEmpMapper staffingEmpMapping;

    @Test
    public void queryEmpByPage() throws Exception {
        List<StaffingEmp> staffingEmps = staffingEmpMapping.queryEmpByPage(1, 0,null, null);
        for (StaffingEmp staffingEmp :
                staffingEmps) {
            System.out.println(staffingEmp);
        }
    }

    @Test
    public void queryEmpById() throws Exception {
        StaffingEmp staffingEmp = staffingEmpMapping.queryEmpById(2);
        System.out.println(staffingEmp);
    }

    @Test
    public void insertEmp() throws Exception {
        StaffingEmp staffingEmp = new StaffingEmp("李康3", "13523016867", "likang3","", 2, "", new Date(), new Date());
        int count = staffingEmpMapping.insertEmp(staffingEmp);
        System.out.println(count);
    }

    @Test
    public void updateEmp() throws Exception {
        StaffingEmp staffingEmp = new StaffingEmp(2, null, null, "", 2, "", null, new Date());
        int count = staffingEmpMapping.updateEmp(staffingEmp);
        System.out.println(count);
    }

}