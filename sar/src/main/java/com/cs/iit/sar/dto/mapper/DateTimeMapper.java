package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.DateTimeResponse;
import com.cs.iit.sar.models.DateTime;

@Mapper
public interface DateTimeMapper {

	DateTimeResponse toDateTimeDto(DateTime dateTime);
}
