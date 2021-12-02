package com.gg.manager.converter;

import com.gg.manager.entity.user.UserPO;
import com.gg.manager.entity.user.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper( UserConverter.class );

    @Mapping(target = "createOn", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updateOn", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "password", ignore = true)
    UserVO toUserVO(UserPO userPO);

    UserPO toUserPO(UserVO userVO);
}
