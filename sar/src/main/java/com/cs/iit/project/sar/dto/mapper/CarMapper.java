package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.project.sar.dto.response.CarResponse;
import com.cs.iit.project.sar.models.Car;

@Mapper
public interface CarMapper {

	CarResponse toCarDto(Car car);
}
