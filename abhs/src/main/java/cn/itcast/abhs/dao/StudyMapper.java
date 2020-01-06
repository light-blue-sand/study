package cn.itcast.abhs.dao;

import cn.itcast.abhs.domain.Study;
import cn.itcast.abhs.domain.StudyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyMapper {
	long countByExample(StudyExample example);

	int deleteByExample(StudyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Study record);

	int insertSelective(Study record);

	List<Study> selectByExample(StudyExample example);

	List<Study> selectAllTask(Study study);

	List<Study> selectAll();

	Study selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Study record, @Param("example") StudyExample example);

	int updateByExample(@Param("record") Study record, @Param("example") StudyExample example);

	int updateByPrimaryKeySelective(Study record);

	int updateByPrimaryKey(Study record);
}