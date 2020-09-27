package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.CarResponse;
import com.cs.iit.sar.models.Car;

@Mapper
public interface CarMapper {

	CarResponse toCarDto(Car car);
}
