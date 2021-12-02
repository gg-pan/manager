package com.gg.manager.dao.sequence;

import com.gg.manager.dao.BaseMapper;
import com.gg.manager.entity.sequence.SequencePO;

public interface SequenceMapper extends BaseMapper<SequencePO> {
    void save(SequencePO sequencePO);
    void update(SequencePO sequencePO);
    SequencePO findSequenceByModule(String module);
}
