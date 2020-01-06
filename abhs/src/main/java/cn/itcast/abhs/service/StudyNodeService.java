package cn.itcast.abhs.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.abhs.domain.StudyNode;

@Transactional
public interface StudyNodeService {
	List<StudyNode> todayShouldReview();

	List<StudyNode> latestNode(StudyNode studyNode);

	List<StudyNode> detailList(Long studyId);

	void completeNode(Long studyNodeId);
}