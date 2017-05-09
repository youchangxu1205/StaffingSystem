package com.hnzzyzy.staffingsystem.web;

import com.hnzzyzy.staffingsystem.entity.StaffingPermission;
import com.hnzzyzy.staffingsystem.service.StaffingPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dtkj_android on 2017/5/9.
 */
@Controller
public class ManagerController {
    @Autowired
    private StaffingPermissionService staffingPermissionService;

    @RequestMapping(value = "/index")
    public String index(Model model) {
        List<StaffingPermission> permissions = staffingPermissionService.getPermissions();
        model.addAttribute("permissions", permissions);
        return "/index";
    }
}
