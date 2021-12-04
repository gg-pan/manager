package com.gg.manager.service;

import com.gg.manager.annotations.BaseColumnGenerator;
import com.gg.manager.entity.common.BasePO;
import com.gg.manager.exception.ValidationException;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseServiceImpl<T extends BasePO> implements BaseService<T> {
    @BaseColumnGenerator
    @Override
    public void save(T t) throws ValidationException {
        t.setCreateOn(LocalDateTime.now());
        t.setUpdateOn(LocalDateTime.now());
        t.setVersion(1);
        t.setLatest(true);
        t.setStatus(true);
        Set<String> validationMessageSet = validation(t);
        if (CollectionUtils.isNotEmpty(validationMessageSet)) {
            throw new ValidationException(validationMessageSet);
        }
        getMapper().save(t);
    }

    public Set<String> validation(T t) {
        return new HashSet<>();
    }

}
