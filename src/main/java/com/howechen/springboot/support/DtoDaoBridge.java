package com.howechen.springboot.support;

import com.howechen.springboot.dto.BaseRequestDto;
import com.howechen.springboot.entity.BaseEntity;

public interface DtoDaoBridge<S extends BaseRequestDto<?, ?>, T extends BaseEntity<?, ?>> {

  T toDao(S dto);

}
