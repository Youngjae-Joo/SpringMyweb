package com.cordhistory.myweb.trip.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.cordhistory.myweb.command.TripVO;

@Mapper
public interface TripMapper {
	
	public int noticeRegist(TripVO vo);
	public ArrayList<TripVO> getList();
	
}
