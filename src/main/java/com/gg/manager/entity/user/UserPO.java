package com.gg.manager.entity.user;

import com.gg.manager.entity.common.BasePO;
import lombok.Data;

@Data
public class UserPO extends BasePO {
    private static final long serialVersionUID = -8268724041925359211L;

    private String name;
    private String email;
    private String phoneNum;
    private String password;

    private String module = "user";
}
