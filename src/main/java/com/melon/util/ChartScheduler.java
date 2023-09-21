package com.melon.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.melon.dto.song.BeforeChartDto;
import com.melon.dto.song.NowChartDto;
import com.melon.service.song.ISongService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ChartScheduler {

	@Autowired
	private MySchedulerService schedulerService;

	private final ISongService songService;

	// 1시간마다 now_chart 데이터(bcd), time_views 테이블에서 상위 100개차트(ncd) 가져오기
	// 초 분 시 일 월 요일
	@Scheduled(cron = "59 59 * * * *")
	public void before_chart() {
		List<BeforeChartDto> bcd = songService.getNowChart();
		schedulerService.setBeforeChartDto(bcd);
		List<NowChartDto> ncd = songService.getTimeViews();
		schedulerService.setNowChartDto(ncd);
	}

	// 1시간마다 before_chart, now_chart 테이블 데이터 삭제
	// 초 분 시 일 월 요일
	@Scheduled(cron = "0 0 * * * *")
	public void deleteChart() {
		songService.deleteNowChart();
		songService.deleteBeforeChart();
	}

	// 1시간마다 bcd를 before_chart, ncd를 now_chart로 보내기
	// 초 분 시 일 월 요일
	@Scheduled(cron = "1 0 * * * *")
	public void now_chart() {
		List<BeforeChartDto> bcd = schedulerService.getBeforeChartDto();
		List<NowChartDto> ncd = schedulerService.getNowChartDto();
		songService.insertBeforeChart(bcd);
		songService.insertNowChart(ncd);
	}
}
