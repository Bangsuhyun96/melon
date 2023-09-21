package com.melon.util;

import java.util.List;

import org.springframework.stereotype.Service;

import com.melon.dto.song.BeforeChartDto;
import com.melon.dto.song.NowChartDto;


@Service
public class MySchedulerService {
	private List<BeforeChartDto> bcd;
	private List<NowChartDto> ncd;
	
	public List<BeforeChartDto> getBeforeChartDto() {
		return bcd;
	}

	public void setBeforeChartDto(List<BeforeChartDto> bcd) {
        this.bcd = bcd;
    }
	
	public List<NowChartDto> getNowChartDto() {
		return ncd;
	}

	public void setNowChartDto(List<NowChartDto> ncd) {
        this.ncd = ncd;
    }
}