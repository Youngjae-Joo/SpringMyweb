package com.cordhistroy.myweb.util;

import lombok.Data;

//sql문에 페이지번호, 데이터개수 전달해줄 클래스
@Data
public class Criteria {
	
	private int page; //페이지번호
	private int amount; //데이터개수
	
	private String searchType; //검색타입
	private String searchName; //검색값
	
	
	public Criteria() {
		this.page=1;
		this.amount=10;
	}
	
	public Criteria (int page, int amount) {
		this.page=page;
		this.amount=amount;
	}

	//limit함수의 페이지시작 부분에 들어갈 getter
	public int getPageStart() {
		return (page-1)*amount;
	}
	
}
