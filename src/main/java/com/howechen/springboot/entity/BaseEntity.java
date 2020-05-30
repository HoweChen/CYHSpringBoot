package com.howechen.springboot.entity;

import com.howechen.springboot.dto.BaseRequestDto;
import com.howechen.springboot.support.DtoDaoBridge;
import java.io.Serializable;

/**
 * @author howechen
 */
public abstract class BaseEntity<S extends BaseRequestDto<?, ?>, T extends BaseEntity<?, ?>> implements
    Serializable, DtoDaoBridge<S, T> {

}
