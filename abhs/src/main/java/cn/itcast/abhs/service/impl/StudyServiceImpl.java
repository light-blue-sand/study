package cn.itcast.abhs.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.itcast.abhs.dao.StudyMapper;
import cn.itcast.abhs.dao.StudyNodeMapper;
import cn.itcast.abhs.domain.Study;
import cn.itcast.abhs.domain.StudyNode;
import cn.itcast.abhs.service.StudyService;
import cn.itcast.abhs.utils.Const;

@Service
public class StudyServiceImpl implements StudyService {
	@Autowired
	private StudyMapper studyMapper;
	@Autowired
	private StudyNodeMapper studyNodeMapper;

	@Override
	public void save(Study study) {
		Date newDate = new Date();
		study.setFinishStatus(Const.FINISH_STATUS_REVIEWYING);
		study.setLearnedTime(newDate);
		studyMapper.insert(study);

		List<StudyNode> nodes = new ArrayList<StudyNode>();
		Calendar calendar = Calendar.getInstance();
		String name = study.getName();
		/*----------
		|* 30分钟    |
		 ----------*/
		calendar.setTime(newDate);
		calendar.add(Calendar.MINUTE, 30);
		StudyNode studyNode = new StudyNode();
		studyNode.setFinishStatus(Const.FINISH_STATUS_WAIT_TO_REVIEW);
		studyNode.setReviewTime(calendar.getTime());
		studyNode.setDateCode("30分钟");
		studyNode.setNodeName(name + "--30分钟");
		studyNode.setStudyId(study.getId());
		nodes.add(studyNode);
		/*----------
		|* 12小时    |
		 ----------*/
		calendar.setTime(newDate);
		calendar.add(Calendar.HOUR_OF_DAY, 12);
		studyNode = new StudyNode();
		studyNode.setFinishStatus(Const.FINISH_STATUS_WAIT_TO_REVIEW);
		studyNode.setReviewTime(calendar.getTime());
		studyNode.setDateCode("12小时");
		studyNode.setNodeName(name + "--12小时");
		studyNode.setStudyId(study.getId());
		nodes.add(studyNode);

		/*--------------------
		| 1, 2, 4, 7, 15天     |
		--------------------*/
		int[] arr = { 1, 2, 4, 7, 15 };
		for (int dateCode : arr) {
			calendar.setTime(newDate);
			calendar.add(Calendar.DATE, dateCode);
			studyNode = new StudyNode();
			studyNode.setFinishStatus(Const.FINISH_STATUS_WAIT_TO_REVIEW);
			studyNode.setReviewTime(calendar.getTime());
			studyNode.setDateCode(dateCode + "天");
			studyNode.setNodeName(name + "--" + dateCode + "天");
			studyNode.setStudyId(study.getId());
			nodes.add(studyNode);
		}
		studyNodeMapper.insertBatch(nodes);
	}

	@Override
	public List<Study> allTask(Study study) {
		if (StringUtils.hasText(study.getName())) {
			study.setName("%" + study.getName() + "%");
		}
		return studyMapper.selectAllTask(study);
	}

	@Override
	public List<Study> selectAll() {
		return studyMapper.selectAll();
	}

	/**
	 * 将study表和study_node表的数据删除, 重新插入表数据
	 */
	@Override
	public void restart(Long studyId) {
		Study study = studyMapper.selectByPrimaryKey(studyId);
		study.setId(null);
		study.setFinishTime(null);
		studyNodeMapper.deleteByStudyId(studyId);
		studyMapper.deleteByPrimaryKey(studyId);
		save(study);
	}

	/**
	 * 将study表和study_node表的数据删除即可
	 */
	@Override
	public void delete(Long studyId) {
		studyNodeMapper.deleteByStudyId(studyId);
		studyMapper.deleteByPrimaryKey(studyId);
	}
}