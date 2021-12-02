package com.gg.manager.service;

import com.gg.manager.dao.BaseMapper;
import com.gg.manager.entity.common.BasePO;

public interface BaseService<T extends BasePO> {
    BaseMapper<T> getMapper();

    void save(T t);
}
