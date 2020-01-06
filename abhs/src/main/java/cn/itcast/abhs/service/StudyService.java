package cn.itcast.abhs.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.abhs.domain.Study;

@Transactional
public interface StudyService {
	void save(Study study);

	List<Study> allTask(Study study);

	List<Study> selectAll();

	void restart(Long studyId);

	void delete(Long studyId);

}