package com.lec.ch16.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch16.service.BoardService;
import com.lec.ch16.util.Paging;
import com.lec.ch16.vo.Board;

@Controller
@RequestMapping("board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(Model model,String pageNum) {
		Paging paging = new Paging(boardService.getBoardTotCnt(),pageNum,10,10);
		model.addAttribute("paging", paging);
		model.addAttribute("boardList", boardService.boardList(paging));
		return "board/list";
	}
	@RequestMapping(value="dummyData70Write", method=RequestMethod.GET)
	public String dummy() {
		boardService.dummyData70Write();
		return "redirect:board/list.do";
	}
	@RequestMapping(value = "content", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardContent(int bid, String after, Model model) {
		model.addAttribute("Board", boardService.boardContent(bid, after));
		return "board/content";
	}
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String Modify(int bid,Model model) {
		model.addAttribute("Board", boardService.boardModifyReplyView(bid));
		return "board/modify";
	}
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String boardModify(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("modifyResult", boardService.boardModify(board, request));
		return "forward:content.do";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String boardDelete(int bid,Model model) {
		model.addAttribute("deleteResult", boardService.boardDelete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public String reply(int bid, Model model) {
		model.addAttribute("Board", boardService.boardModifyReplyView(bid));
		return "board/reply";
	}
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public String boardReply(Board board, Model model, HttpServletRequest request) {
		model.addAttribute("replyResult", boardService.boardReply(board, request));
		return "forward:content.do";
	}
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String boardWrite(Model model) {
		return "board/write";
	}
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String boardWrite(Board board, HttpServletRequest request  ,Model model) {
		model.addAttribute("writeResult", boardService.boardWrite(board, request));
		return "forward:list.do";
	}
	
	
}
