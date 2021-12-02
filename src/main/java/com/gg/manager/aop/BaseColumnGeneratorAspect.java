package com.gg.manager.aop;

import com.gg.manager.entity.common.BasePO;
import com.gg.manager.service.sequence.SequenceService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Aspect
@Component
public class BaseColumnGeneratorAspect {

    @Resource
    private SequenceService sequenceService;

    private BasePO basePO;

    @Pointcut("@annotation(com.gg.manager.annotations.BaseColumnGenerator)")
    public void baseColumnGenerator() {}

    @Around("baseColumnGenerator()")
    public void aroundPointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] objects = proceedingJoinPoint.getArgs();
        for(Object object : objects) {
            if (object instanceof BasePO) {
                this.basePO = (BasePO) object;
                break;
            }
        }
        proceedingJoinPoint.proceed();
    }

    @Before("baseColumnGenerator()")
    public void beforeProceed() {
        if (this.basePO == null) {
            return;
        }
        if (StringUtils.isEmpty(this.basePO.getId())) {
            this.basePO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        setRefNum();
    }

    private void setRefNum() {
        if (StringUtils.isNotEmpty(basePO.getRefNo())) {
            return;
        }
        basePO.setRefNo(sequenceService.findReferenceNumByModule(basePO.getModule()));
    }
}
