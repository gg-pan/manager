package com.gg.manager.service;

import com.gg.manager.annotations.BaseColumnGenerator;
import com.gg.manager.entity.common.BasePO;

import java.time.LocalDateTime;

public abstract class BaseServiceImpl<T extends BasePO> implements BaseService<T> {
    @BaseColumnGenerator
    @Override
    public void save(T t) {
        t.setCreateOn(LocalDateTime.now());
        t.setUpdateOn(LocalDateTime.now());
        t.setVersion(1);
        t.setLatest(true);
        t.setStatus(true);
        getMapper().save(t);
    }
}
