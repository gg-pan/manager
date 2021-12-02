package com.gg.manager.dao.user;

import com.gg.manager.dao.BaseMapper;
import com.gg.manager.entity.user.UserPO;

public interface UserMapper extends BaseMapper<UserPO> {
    UserPO findUserById(String id);

    UserPO findUserByPhoneNum(String phoneNum);

    UserPO findUserByName(String name);
}
