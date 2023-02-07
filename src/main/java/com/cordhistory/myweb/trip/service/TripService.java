package com.cordhistory.myweb.trip.service;

import java.util.ArrayList;

import com.cordhistory.myweb.command.TripVO;

public interface TripService {
	
	public int noticeRegist(TripVO vo);
	public ArrayList<TripVO> getList();
}
