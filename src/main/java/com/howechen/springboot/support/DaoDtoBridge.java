package com.howechen.springboot.support;

import com.howechen.springboot.dto.BaseRequestDto;
import com.howechen.springboot.entity.BaseEntity;

/**
 * @author howechen
 */
public interface DaoDtoBridge<S extends BaseRequestDto<?, ?>, T extends BaseEntity<?, ?>> {

  S fromDao(T dao);

}
