package com.cs.iit.sar.dto.mapper;

import org.mapstruct.Mapper;

import com.cs.iit.sar.dto.response.ReportResponse;
import com.cs.iit.sar.dto.response.SingleReportDetailResponse;
import com.cs.iit.sar.models.Report;
import com.cs.iit.sar.models.ReportDetail;

@Mapper
public interface ReportDetailResponseMapper {

	SingleReportDetailResponse toReportDetailDto(ReportDetail reportDetail);
	
	ReportResponse toReportDto(Report report);
}
