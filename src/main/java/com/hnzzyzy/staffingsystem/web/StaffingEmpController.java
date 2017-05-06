package com.hnzzyzy.staffingsystem.web;

import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
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
    public Object list(int limit, int offset, String sort, String order, StaffingEmp staffingEmp) {
        String sortByOrder = null;
        if (sort != null && sort != "" && order != null && order != "") {
            if (sort.equals("empId")) {
                sort = "emp_id";
            } else if (sort.equals("empStatus")) {
                sort = "emp_status";
            } else if (sort.equals("beFormalTime")) {
                sort = "be_formal_time";
            }
            else if (sort.equals("entryTime")) {
                sort = "entry_time";
            }
            sortByOrder = sort + " " + order;
        }
        List<StaffingEmp> rows =
                staffingEmpService.getEmpListByPage(limit, offset, sortByOrder, staffingEmp);
        long total = staffingEmpService.getAllCount(staffingEmp);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
}
