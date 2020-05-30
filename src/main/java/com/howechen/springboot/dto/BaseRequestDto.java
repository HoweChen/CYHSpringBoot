package com.howechen.springboot.dto;

import com.howechen.springboot.entity.BaseEntity;
import com.howechen.springboot.support.DaoDtoBridge;
import com.howechen.springboot.support.DtoDaoBridge;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author howechen
 */
public abstract class BaseRequestDto<S extends BaseRequestDto<?, ?>, T extends BaseEntity<?, ?>> implements
    DaoDtoBridge<S, T>, Serializable {

}
