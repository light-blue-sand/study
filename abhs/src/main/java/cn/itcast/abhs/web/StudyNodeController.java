package cn.itcast.abhs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.abhs.domain.Study;
import cn.itcast.abhs.domain.StudyNode;
import cn.itcast.abhs.service.StudyNodeService;
import cn.itcast.abhs.service.StudyService;

@Controller
@RequestMapping("/studyNode")
public class StudyNodeController {
	@Autowired
	private StudyNodeService studyNodeService;
	@Autowired
	private StudyService studyService;

	/**
	 * 今日应学, 将应学的学习节点查询出来
	 * 
	 * @return
	 */
	@RequestMapping("/index.do")
	public String index(Model model) {
		List<StudyNode> list = studyNodeService.todayShouldReview();
		model.addAttribute("list", list);
		return "studyNode/index";
	}

	/**
	  * 查询最新复习任务节点, 根据时间倒序排序
	 * 
	 * @return
	 */
	@RequestMapping("/latestNode.do")
	public String latestNode(StudyNode studyNode, Model model) {
		List<Study> studyList = studyService.selectAll();
		model.addAttribute("studyList", studyList);

		List<StudyNode> list = studyNodeService.latestNode(studyNode);
		model.addAttribute("list", list);
		return "studyNode/latestNode";
	}

	@RequestMapping("/detailList.do")
	public String detailList(Long studyId, Model model) {
		List<StudyNode> nodeList = studyNodeService.detailList(studyId);
		model.addAttribute("nodeList", nodeList);
		return "studyNode/detailList";
	}

	/**
	 *  完成节点, 更新状态和完成时间
	 *  如果是最后一个节点, 所属主表的状态和完成时间也要更新
	 */
	@RequestMapping("/completeNode.do")
	public String completeNode(Long studyNodeId) {
		studyNodeService.completeNode(studyNodeId);
		return "redirect:/studyNode/index.do";
	}
}
