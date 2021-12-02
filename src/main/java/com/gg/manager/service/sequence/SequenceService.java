package com.gg.manager.service.sequence;

import com.gg.manager.entity.sequence.SequencePO;
import com.gg.manager.service.BaseService;

public interface SequenceService extends BaseService<SequencePO> {
    SequencePO findSequenceByModule(String module);
    String findReferenceNumByModule(String module);
}
