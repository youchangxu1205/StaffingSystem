package com.hnzzyzy.staffingsystem.web;

import com.alibaba.fastjson.JSONArray;
import com.hnzzyzy.staffingsystem.service.StaffingOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xcy on 2017/5/7.
 */
@Controller
@RequestMapping("/org")
public class StaffingOrgController {
    @Autowired
    private StaffingOrgService staffingOrgService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "/org/orgTree";
    }

    @RequestMapping(value = "/orgTree",method = RequestMethod.POST)
    @ResponseBody
    public Object orgTree(Long orgId){
        JSONArray orgTree = staffingOrgService.getOrgTree(orgId);
        return orgTree;
    }
}
