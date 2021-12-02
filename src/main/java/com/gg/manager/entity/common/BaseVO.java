package com.gg.manager.entity.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseVO implements Serializable  {
    private static final long serialVersionUID = -6351432557673034984L;

    private LocalDateTime createOn;
    private LocalDateTime updateOn;
    private int version;
    private String refNo;
    private boolean latest;
    private boolean status;
}
