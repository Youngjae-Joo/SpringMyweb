package com.cordhistory.myweb.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cordhistory.myweb.command.TripVO;
import com.cordhistory.myweb.trip.service.TripService;

@Controller
@RequestMapping("/trip")
public class NoticeController {
	
	@Autowired
	@Qualifier("tripService")
	private TripService tripService;
	
	//목록
	@RequestMapping("/notice_list")
	public String notice_list(Model model) {
		/*
		 * service, mapper영역에 getList함수를 선언하고
		 * 등록번호 역순으로 데이터를 조회해서 가지고 나옵니다.
		 * model에 담아서
		 * 화면에서는 반복문으로 처리.
		 *  
		 */
		ArrayList<TripVO> list = tripService.getList();
		model.addAttribute("list",list);
		return "trip/notice_list";
	}
	
	
	//상세페이지
	@RequestMapping("/notice_view")
	public String notice_view(@RequestParam("tno")int tno, Model model,HttpServletResponse response, HttpServletRequest request) {
		
		//조회수-Cookie or 세션 이용해서 조회수 중복 방지
		Cookie[] cookies=request.getCookies();
		int countCookie=0;
		
			for(Cookie c : cookies) {
				if(c.getName().equals(Integer.toString(tno))) {
					countCookie++;
					c.setMaxAge(30);
				}
			}
			
			if(countCookie==0) {
				Cookie cookie = new Cookie(Integer.toString(tno),"1");
				cookie.setMaxAge(30);
				response.addCookie(cookie);
				tripService.hitUpdate(tno); //조회수 업데이트
			}
		
			//클릭한 글 번호에 대한 내용을 조회
			TripVO vo = tripService.getContent(tno);
			model.addAttribute("vo",vo);
		
		
		
		
		//이전글, 다음글
		ArrayList<TripVO> list = tripService.getPrevNext(tno);
		model.addAttribute("list", list);
		
		return "trip/notice_view";
	}
	
	//등록페이지
	@RequestMapping("/notice_write")
	public String notice_write() {
		return "trip/notice_write";
	}
	
	
	//수정화면
	@RequestMapping("/notice_modify")
	public String notice_modify(@RequestParam("tno")int tno,Model model) {
		TripVO vo = tripService.getContent(tno);
		model.addAttribute("vo",vo);
		return "trip/notice_modify";
	}
	
	//수정하기
	@RequestMapping(value="/modifyForm", method=RequestMethod.POST)
	public String modifyForm(TripVO vo, RedirectAttributes ra) {
		
		//업데이트작업-화면에서는 tno가 필요하기 때문에 hidden태그를 이용해서 넘겨준다.		
		int result=tripService.noticeModify(vo);
		String msg=result==1?"문의사항이 수정되었습니다.":"수정에 실패했습니다.";
		ra.addFlashAttribute("msg",msg);
		return "redirect:/trip/notice_view?tno="+vo.getTno();
	}
	
	
	//수정, 상세 화면이 완전 동일하다면
//	@RequestMapping({"notice_view", "notice_modify"}) //배열임
//	public void notice_view(@RequestParam("tno")int tno, Model model) {
//		TripVO vo = tripService.getContent(tno);
//		model.addAttribute("vo",vo);
//	}
	
	
	
	//글등록
	@RequestMapping(value="/registForm", method=RequestMethod.POST)
	public String registForm(TripVO vo,RedirectAttributes ra) {
		int result = tripService.noticeRegist(vo);
		String msg=result==1?"문의사항이 정상 등록되었습니다.":"문의 등록에 실패했습니다.";
		ra.addFlashAttribute("msg", msg);
		return "redirect:/trip/notice_list";
	}
	
	//글삭제
	@RequestMapping(value="/deleteForm", method=RequestMethod.POST)
	public String deleteForm(@RequestParam("tno")int tno, RedirectAttributes ra) {
		/*
		 * service, mapper에는 noticeDelete 메서드로 삭제를 진행
		 * 삭제 이후에는 list화면으로 이동해주면 됩니다.
		 */
		int result=tripService.noticeDelete(tno);
		String msg=result==1?"삭제되었습니다.":"삭제에 실패하였습니다.";
		ra.addFlashAttribute("msg", msg);
		return "redirect:/trip/notice_list";
	}
	
	
	
	
}
