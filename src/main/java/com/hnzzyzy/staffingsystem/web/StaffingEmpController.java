package com.hnzzyzy.staffingsystem.web;

import com.hnzzyzy.staffingsystem.dto.StaffingSystemResult;
import com.hnzzyzy.staffingsystem.entity.StaffingEmp;
import com.hnzzyzy.staffingsystem.enums.StaffingSystemResultConstant;
import com.hnzzyzy.staffingsystem.exception.InsertErrorException;
import com.hnzzyzy.staffingsystem.exception.UserNameExitException;
import com.hnzzyzy.staffingsystem.service.StaffingEmpService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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
    public String create() {
        return "/emp/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object create(StaffingEmp staffingEmp) {

        try {
            staffingEmpService.insertEmp(staffingEmp);
        } catch (UserNameExitException e) {
            return new StaffingSystemResult(StaffingSystemResultConstant.USERNAME_IS_EXITED, e);
        } catch (InsertErrorException e) {
            return new StaffingSystemResult(StaffingSystemResultConstant.INSERT_ERROR, e);
        }

        return new StaffingSystemResult(StaffingSystemResultConstant.SUCCESS, "");
    }

    @RequestMapping(value = "/update/{empId}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable("empId") long empId) {
        StaffingEmp staffingEmp = staffingEmpService.getEmpById(empId);
        model.addAttribute("staffingEmp", staffingEmp);
        return "/emp/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object update(StaffingEmp staffingEmp) {

        try {
            staffingEmpService.updateEmp(staffingEmp);
        } catch (InsertErrorException e) {
            return new StaffingSystemResult(StaffingSystemResultConstant.UPDATE_ERROR, e);
        }
        StaffingSystemResult staffingSystemResult = new StaffingSystemResult(StaffingSystemResultConstant.SUCCESS, "");
        return staffingSystemResult;
    }


    public Object importEmp(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            Workbook wb = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
