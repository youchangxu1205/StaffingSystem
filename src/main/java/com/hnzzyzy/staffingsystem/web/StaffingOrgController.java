package com.hnzzyzy.staffingsystem.web;

import com.alibaba.fastjson.JSONArray;
import com.hnzzyzy.staffingsystem.dto.StaffingSystemResult;
import com.hnzzyzy.staffingsystem.entity.StaffingOrg;
import com.hnzzyzy.staffingsystem.enums.StaffingSystemResultConstant;
import com.hnzzyzy.staffingsystem.service.StaffingOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xcy on 2017/5/7.
 */
@Controller
@RequestMapping("/org")
public class StaffingOrgController {
    @Autowired
    private StaffingOrgService staffingOrgService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/org/index";
    }

    @RequestMapping(value = "/orgTree", method = RequestMethod.POST)
    @ResponseBody
    public Object orgTree(Long orgId) {
        JSONArray orgTree = staffingOrgService.getOrgTree(orgId);
        return orgTree;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(int limit, int offset, String sort, String order, StaffingOrg staffingOrg) {
        String sortByOrder = null;
        List<StaffingOrg> rows =
                staffingOrgService.getOrgListByPage(limit, offset, sortByOrder, staffingOrg);
        long total = staffingOrgService.getAllCount(staffingOrg);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "/org/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Object create(StaffingOrg staffingOrg) {
        int count = staffingOrgService.insertOrg(staffingOrg);
        if (count == 1) {
            return new StaffingSystemResult(StaffingSystemResultConstant.SUCCESS, "保存成功");
        }
        return new StaffingSystemResult(StaffingSystemResultConstant.INSERT_ERROR, "保存失败");
    }

    @RequestMapping(value = "/update/{orgId}", method = RequestMethod.GET)
    public String update(@PathVariable("orgId") long orgId, Model model) {
        StaffingOrg staffingOrg = staffingOrgService.getOrgById(orgId);
        model.addAttribute("staffingOrg", staffingOrg);
        return "/org/update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Object update(StaffingOrg staffingOrg){

        int count = staffingOrgService.updateOrg(staffingOrg);
        if(count==0){
            return new StaffingSystemResult(StaffingSystemResultConstant.UPDATE_ERROR,"修改失败");
        }
        return new StaffingSystemResult(StaffingSystemResultConstant.SUCCESS,"修改成功");
    }




}
