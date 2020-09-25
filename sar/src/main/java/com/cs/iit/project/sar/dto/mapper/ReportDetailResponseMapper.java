package com.cs.iit.project.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.project.sar.dto.response.ReportResponse;
import com.cs.iit.project.sar.dto.response.SingleReportDetailResponse;
import com.cs.iit.project.sar.models.Report;
import com.cs.iit.project.sar.models.ReportDetail;

@Mapper
public interface ReportDetailResponseMapper {

	SingleReportDetailResponse toReportDetailDto(ReportDetail reportDetail);
	
	ReportResponse toReportDto(Report report);
}
