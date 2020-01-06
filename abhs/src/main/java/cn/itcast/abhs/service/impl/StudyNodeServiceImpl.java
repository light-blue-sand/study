package cn.itcast.abhs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.itcast.abhs.dao.StudyMapper;
import cn.itcast.abhs.dao.StudyNodeMapper;
import cn.itcast.abhs.domain.Study;
import cn.itcast.abhs.domain.StudyNode;
import cn.itcast.abhs.service.StudyNodeService;
import cn.itcast.abhs.utils.Const;

@Service
public class StudyNodeServiceImpl implements StudyNodeService {
	@Autowired
	private StudyNodeMapper studyNodeMapper;
	@Autowired
	private StudyMapper studyMapper;

	/**
	 * 今日应学, 将应学的学习节点查询出来 将(待复习的, 系统时间晚于学习时间的, 不超过一天)的查询出来
	 */
	@Override
	public List<StudyNode> todayShouldReview() {
		List<StudyNode> list = studyNodeMapper.selectShould();
		return list;
	}

	@Override
	public List<StudyNode> latestNode(StudyNode studyNode) {
		return studyNodeMapper.selectLatestNode(studyNode);
	}

	@Override
	public List<StudyNode> detailList(Long studyId) {
		return studyNodeMapper.detailList(studyId);
	}

	/**
	 *  完成节点, 更新状态和完成时间
	 *  如果是最后一个节点, 所属主表的状态和完成时间也要更新
	 */
	@Override
	public void completeNode(Long studyNodeId) {
		StudyNode studyNode = studyNodeMapper.selectByPrimaryKey(studyNodeId);
		studyNode.setFinishStatus(Const.FINISH_STATUS_COMPLETED);
		studyNode.setFinishedTime(new Date());
		studyNodeMapper.updateByPrimaryKey(studyNode);
		if ("15天".equals(studyNode.getDateCode())) {// 最后一个节点
			Study record = new Study();
			record.setId(studyNode.getStudyId());
			record.setFinishStatus(Const.FINISH_STATUS_COMPLETED);
			record.setFinishTime(new Date());
			studyMapper.updateByPrimaryKeySelective(record);
		}
	}

}