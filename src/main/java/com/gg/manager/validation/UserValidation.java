package com.gg.manager.validation;

import com.gg.manager.entity.user.UserPO;
import com.gg.manager.service.user.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserValidation {
    @Resource
    private UserService userService;

    public String mandatoryValidation(UserPO userPO) {
        List<String> errorColumnList = new ArrayList<>();
        if (StringUtils.isEmpty(userPO.getPhoneNum())) {
            errorColumnList.add("Phone Number");
        }
        if (StringUtils.isEmpty(userPO.getName())) {
            errorColumnList.add("Name");
        }
        if (StringUtils.isEmpty(userPO.getPassword())) {
            errorColumnList.add("Password");
        }

        return CollectionUtils.isEmpty(errorColumnList) ? null : StringUtils.join(errorColumnList, ", ") + " is mandatory field.";
    }

    public String uniqueValidation(UserPO userPO) {
        List<String> errorColumnList = new ArrayList<>();
        UserPO phoneNumUser = userService.findUserByPhoneNum(userPO.getPhoneNum());
        if (phoneNumUser != null) {
            errorColumnList.add("Phone Number");
        }

        UserPO nameUser = userService.findUserByName(userPO.getName());
        if (nameUser != null) {
            errorColumnList.add("Name");
        }

        return CollectionUtils.isEmpty(errorColumnList) ? null : StringUtils.join(errorColumnList, ", ") + " already exists.";
    }
}
