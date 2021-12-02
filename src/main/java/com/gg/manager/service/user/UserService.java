package com.gg.manager.service.user;

import com.gg.manager.entity.user.UserPO;
import com.gg.manager.service.BaseService;

public interface UserService extends BaseService<UserPO> {
    UserPO findUserById(String id);

    UserPO findUserByPhoneNum(String phoneNum);

    UserPO findUserByName(String name);

    String login(UserPO userPO);
}
