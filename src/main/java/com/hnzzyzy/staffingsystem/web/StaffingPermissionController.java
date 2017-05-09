package com.hnzzyzy.staffingsystem.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hnzzyzy.staffingsystem.entity.StaffingPermission;
import com.hnzzyzy.staffingsystem.service.StaffingPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dtkj_android on 2017/5/9.
 */
@RequestMapping(value = "/permission")
@Controller
public class StaffingPermissionController {
    @Autowired
    private StaffingPermissionService staffingPermissionService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/permission/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(int limit, int offset, String sort, String order,StaffingPermission staffingPermission) {
        EntityWrapper<StaffingPermission> entityWrapper = new EntityWrapper<>(staffingPermission);
        entityWrapper.orderBy(sort,true);
        List<StaffingPermission> permissions = staffingPermissionService.getPermissions();
        int total = staffingPermissionService.queryAllCount();
        Map<String, Object> result = new HashMap<>();
        result.put("rows", permissions);
        result.put("total", total);
        return result;
    }
}
