package com.yaic.app.order.dto;

import java.util.Comparator;

import com.yaic.app.order.dto.custom.PolicyInfo;

public class SortPolicyInfo implements Comparator<PolicyInfo> {
    public int compare(PolicyInfo d1, PolicyInfo d2) {

        if (d1 == null && d2 == null) {
            return 0;
        }
        if (d1 == null) {
            return -1;
        }
        if (d2 == null) {
            return 1;
        }
        int flag = d2.getAddTime().compareTo(d1.getAddTime());
        return flag;
    }
}
