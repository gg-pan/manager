package com.gg.manager.entity.sequence;

import com.gg.manager.entity.common.BasePO;
import lombok.Data;

@Data
public class SequencePO extends BasePO {
    private static final long serialVersionUID = 8742752280044836993L;

    private int sequence;
    private String prefix;
}
