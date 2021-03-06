package com.gg.manager.service.user.implement;

import com.gg.manager.dao.BaseMapper;
import com.gg.manager.dao.user.UserMapper;
import com.gg.manager.entity.user.UserPO;
import com.gg.manager.service.BaseServiceImpl;
import com.gg.manager.service.user.UserService;
import com.gg.manager.utils.JWTUtil;
import com.gg.manager.validation.UserValidation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserPO> implements UserService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserValidation userValidation;

    @Override
    public UserPO findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public UserPO findUserByPhoneNum(String phoneNum) {
        return userMapper.findUserByPhoneNum(phoneNum);
    }

    @Override
    public UserPO findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public String login(UserPO loginUser) {
        UserPO userPO = userService.findUserByPhoneNum(loginUser.getPhoneNum());
        if (userPO == null) {
            userPO = userService.findUserByName(loginUser.getName());
        }
        if (userPO == null) {
            throw new RuntimeException("can not find user:" + loginUser.getPhoneNum());
        }
        if (!StringUtils.equals(userPO.getPassword(), loginUser.getPassword())) {
            throw new RuntimeException("verify password fail");
        }

        Map<String, String> payload = new HashMap<>(2);
        payload.put("phoneNum", userPO.getPhoneNum());
        payload.put("password", userPO.getPassword());
        return JWTUtil.getToken(payload);
    }

    @Override
    public BaseMapper<UserPO> getMapper() {
        return userMapper;
    }

    @Override
    public Set<String> validation(UserPO userPO) {
        Set<String> messageSet = new HashSet<>();
        String mandatoryValidationMessage = userValidation.mandatoryValidation(userPO);
        String uniqueValidationMessage = userValidation.uniqueValidation(userPO);

        if (StringUtils.isNotEmpty(mandatoryValidationMessage)) {
            messageSet.add(mandatoryValidationMessage);
        }
        if (StringUtils.isNotEmpty(uniqueValidationMessage)) {
            messageSet.add(uniqueValidationMessage);
        }

        return messageSet;
    }
}
