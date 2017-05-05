package com.hnzzyzy.staffingsystem.dto;

import com.hnzzyzy.staffingsystem.enums.StaffingSystemResultConstant;

/**
 * Created by dtkj_android on 2017/5/5.
 */
public class StaffingSystemResult extends BaseResult {

    public StaffingSystemResult(StaffingSystemResultConstant staffingSystemResultConstant, Object data) {
        super(staffingSystemResultConstant.getCode(), staffingSystemResultConstant.getMessage(), data);
    }
}
