package com.hnzzyzy.staffingsystem.web;

import com.hnzzyzy.staffingsystem.dto.StaffingSystemResult;
import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import com.hnzzyzy.staffingsystem.enums.StaffingSystemResultConstant;
import com.hnzzyzy.staffingsystem.service.StaffingEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dtkj_android on 2017/5/5.
 */
@Controller
@RequestMapping("/emp")
public class StaffingEmpController {
    @Autowired
    private StaffingEmpService staffingEmpService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/emp/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        List<StaffingEmp> rows = staffingEmpService.getEmpListByPage(10, 0, null);
        long total = staffingEmpService.getAllCount();
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
}
