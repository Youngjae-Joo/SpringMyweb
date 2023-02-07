package com.cordhistory.myweb.trip.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cordhistory.myweb.command.TripVO;

@Service("tripService")
public class TripServiceImpl implements TripService{

	@Autowired
	private TripMapper tripMapper;

	@Override
	public int noticeRegist(TripVO vo) {
		return tripMapper.noticeRegist(vo);
	}

	@Override
	public ArrayList<TripVO> getList() {
		
		return tripMapper.getList();
	}
	
	
}
