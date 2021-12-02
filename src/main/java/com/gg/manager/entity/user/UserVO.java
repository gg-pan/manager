package com.gg.manager.entity.user;

import com.gg.manager.entity.common.BaseVO;
import lombok.Data;

@Data
public class UserVO extends BaseVO {
    private static final long serialVersionUID = -6537783997339203291L;

    private String name;
    private String email;
    private String phoneNum;
    private String password;
}
