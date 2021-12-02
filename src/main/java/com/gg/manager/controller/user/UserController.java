package com.gg.manager.controller.user;

import com.gg.manager.controller.AbstractController;
import com.gg.manager.converter.UserConverter;
import com.gg.manager.entity.user.UserPO;
import com.gg.manager.entity.user.UserVO;
import com.gg.manager.response.Result;
import com.gg.manager.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractController {
    @Resource
    private UserService userService;

    @GetMapping("/{id}")
    public UserVO findUserById(@PathVariable("id") String id) {
        UserPO userPO = userService.findUserById(id);
        return UserConverter.INSTANCE.toUserVO(userPO);
    }

    @ResponseBody
    @PostMapping("/login")
    public Result<String> login(@RequestBody UserVO loginUser) {
        UserPO userPO = UserConverter.INSTANCE.toUserPO(loginUser);
        try {
            return successResponse("Login successful", userService.login(userPO));
        } catch (Exception exception) {
            return new Result<>(HttpStatus.UNAUTHORIZED.value(), exception.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("/save")
    public UserVO save(@RequestBody UserVO userVO) {
        userService.save(UserConverter.INSTANCE.toUserPO(userVO));
        UserPO userPO = userService.findUserByName(userVO.getName());
        return UserConverter.INSTANCE.toUserVO(userPO);
    }
}
