package com.gg.manager.entity.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BasePO implements Serializable {
    private static final long serialVersionUID = 3145079512228522170L;

    private String id;
    private LocalDateTime createOn;
    private LocalDateTime updateOn;
    private int version;
    private String refNo;
    private boolean latest;
    private boolean status;

    protected String module;
}
