package com.coderhistory.myweb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cordhistory.myweb.command.TripVO;
import com.cordhistory.myweb.trip.service.TripMapper;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //동작시킬 스프링 설정파일
public class PageTest {
	
	@Autowired
	TripMapper tripMapper;
	
	
//	@Test
//	public void testCode01() {
//		
//		for(int i=1;i<=300;i++) {
//			TripVO vo = new TripVO(0, "2023-02-08","admin"+i,"tester"+i,"example"+i,0,null);
//			tripMapper.noticeRegist(vo);
//		}
//	}
	
	
	
}
