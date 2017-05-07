package com.hnzzyzy.staffingsystem.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hnzzyzy.staffingsystem.dao.StaffingOrgMapper;
import com.hnzzyzy.staffingsystem.entity.StaffingOrg;
import com.hnzzyzy.staffingsystem.service.StaffingOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xcy on 2017/5/7.
 */
@Service
public class StaffingOrgServiceImpl implements StaffingOrgService {
    @Autowired
    private StaffingOrgMapper staffingOrgMapper;
    @Override
    public JSONArray getOrgTree(Long orgId) {

        JSONArray orgs = new JSONArray();
        if(orgId==null){

        }
        StaffingOrg staffingOrg = staffingOrgMapper.queryOrgById(orgId);
        JSONObject topOrg = new JSONObject();
        topOrg.put("id",staffingOrg.getOrgId());
        topOrg.put("name",staffingOrg.getOrgName());
        topOrg.put("open",true);
        JSONArray childArray = getChildOrgTree(orgId);
        topOrg.put("children",childArray);
        orgs.add(topOrg);
        return orgs;
    }


    public JSONArray getChildOrgTree(Long orgId){
        List<StaffingOrg> childOrgs = staffingOrgMapper.queryChildOrgById(orgId);
        JSONArray childArray = new JSONArray();
        if(childOrgs.size()>0){
            for (StaffingOrg childOrg :
                    childOrgs) {
                JSONObject node = new JSONObject();
                node.put("id",childOrg.getOrgId());
                node.put("name",childOrg.getOrgName());
                node.put("open",true);
                JSONArray childArray1 = getChildOrgTree(childOrg.getOrgId());
                node.put("children",childArray1);
                childArray.add(node);
            }
        }
        return childArray;
    }


    @Override
    public StaffingOrg getOrgById(Long orgId) {
        return staffingOrgMapper.queryOrgById(orgId);
    }

    @Override
    public List<StaffingOrg> getChildOrgById(Long orgId) {

        return staffingOrgMapper.queryChildOrgById(orgId);
    }

}
