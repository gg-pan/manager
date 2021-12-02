package com.gg.manager.service.sequence.implement;

import com.gg.manager.dao.BaseMapper;
import com.gg.manager.dao.sequence.SequenceMapper;
import com.gg.manager.entity.sequence.SequencePO;
import com.gg.manager.service.BaseServiceImpl;
import com.gg.manager.service.sequence.SequenceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class SequenceServiceImpl extends BaseServiceImpl<SequencePO> implements SequenceService {
    @Resource
    private SequenceService sequenceService;

    @Resource
    private SequenceMapper sequenceMapper;


    @Override
    public BaseMapper<SequencePO> getMapper() {
        return sequenceMapper;
    }

    @Override
    public SequencePO findSequenceByModule(String module) {
        return sequenceMapper.findSequenceByModule(module);
    }

    @Override
    public String findReferenceNumByModule(String module) {
        SequencePO sequencePO = sequenceService.findSequenceByModule(module);
        if (sequencePO == null) {
            return null;
        }
        String prefix = sequencePO.getPrefix();
        LocalDateTime updateOn = sequencePO.getUpdateOn();
        LocalDateTime now = LocalDateTime.now();
        if (now.getYear() != updateOn.getYear() || now.getMonthValue() != updateOn.getMonthValue()) {
            sequencePO.setSequence(0);
        }
        sequencePO.setSequence(sequencePO.getSequence()+1);
        int sequence = sequencePO.getSequence();
        sequenceMapper.update(sequencePO);

        return prefix
                + now.getYear()
                + StringUtils.leftPad(String.valueOf(now.getMonthValue()), 2, "0")
                + '-'
                + StringUtils.leftPad(String.valueOf(sequence), 4, "0");
    }
}
