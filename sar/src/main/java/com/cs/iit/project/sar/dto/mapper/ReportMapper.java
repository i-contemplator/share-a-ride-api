package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cs.iit.project.sar.dto.response.SingleReportResponse;
import com.cs.iit.project.sar.dto.response.ViewReportsResponse;
import com.cs.iit.project.sar.models.Report;
import com.cs.iit.project.sar.models.ViewReports;

@Mapper(uses = {ReportDetailResponseMapper.class})
public interface ReportMapper {

	ReportMapper INSTANCE = Mappers.getMapper(ReportMapper.class);
	
	SingleReportResponse toReportDto(Report report);
	
	ViewReportsResponse toViewReportsDto(ViewReports reports);
}

