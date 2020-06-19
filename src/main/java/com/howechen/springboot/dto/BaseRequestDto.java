package com.howechen.springboot.dto;

import com.howechen.springboot.entity.BaseEntity;
import com.howechen.springboot.support.DaoDtoBridge;
import java.io.Serializable;

/**
 * @author howechen
 */
public abstract class BaseRequestDto<S extends BaseRequestDto<?, ?>, T extends BaseEntity<?, ?>> implements
    DaoDtoBridge<S, T>, Serializable {

}
