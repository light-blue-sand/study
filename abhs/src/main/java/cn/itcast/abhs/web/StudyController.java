package cn.itcast.abhs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.abhs.domain.Study;
import cn.itcast.abhs.service.StudyService;

@Controller
@RequestMapping("/study")
public class StudyController {
	@Autowired
	private StudyService studyService;

	@RequestMapping("/save.do")
	public String save(Study study) {
		studyService.save(study);
		return "redirect:/studyNode/index.do";
	}

	@RequestMapping("/allTask.do")
	public String allTask(Study study, Model model) {
		List<Study> studyList = studyService.allTask(study);
		model.addAttribute("studyList", studyList);
		model.addAttribute("study", study);
		return "study/allTask";
	}

	/**
	 * 将study表和study_node表的数据删除, 重新插入表数据
	 */
	@RequestMapping("/restart.do")
	public String restart(Long studyId) {
		studyService.restart(studyId);
		return "redirect:/study/allTask.do";
	}

	/**
	 * 将study表和study_node表的数据删除
	 */
	@RequestMapping("/delete.do")
	public String delete(Long studyId) {
		studyService.delete(studyId);
		return "redirect:/study/allTask.do";
	}
}
