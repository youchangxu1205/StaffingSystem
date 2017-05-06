package com.hnzzyzy.staffingsystem.web;

import com.hnzzyzy.staffingsystem.dto.StaffingSystemResult;
import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import com.hnzzyzy.staffingsystem.enums.StaffingSystemResultConstant;
import com.hnzzyzy.staffingsystem.exception.InsertErrorException;
import com.hnzzyzy.staffingsystem.exception.UserNameExitException;
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
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(){
        return "/emp/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object createPost(StaffingEmp staffingEmp){

        try {
            staffingEmpService.insertEmp(staffingEmp);
        } catch (UserNameExitException e) {
            return new StaffingSystemResult(StaffingSystemResultConstant.USERNAME_IS_EXITED,e);
        } catch (InsertErrorException e){
            return new StaffingSystemResult(StaffingSystemResultConstant.INSERT_ERROR,e);
        }

        return new StaffingSystemResult(StaffingSystemResultConstant.SUCCESS,null);
    }
}
