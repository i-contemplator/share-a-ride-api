package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.project.sar.dto.response.DateTimeResponse;
import com.cs.iit.project.sar.models.DateTime;

@Mapper
public interface DateTimeMapper {

	DateTimeResponse toDateTimeDto(DateTime dateTime);
}
