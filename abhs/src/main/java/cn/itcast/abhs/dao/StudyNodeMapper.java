package cn.itcast.abhs.dao;

import cn.itcast.abhs.domain.StudyNode;
import cn.itcast.abhs.domain.StudyNodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudyNodeMapper {
	long countByExample(StudyNodeExample example);

	int deleteByExample(StudyNodeExample example);

	int deleteByPrimaryKey(Long id);

	int deleteByStudyId(Long studyId);

	int insert(StudyNode record);

	int insertSelective(StudyNode record);

	List<StudyNode> selectByExample(StudyNodeExample example);

	StudyNode selectByPrimaryKey(Long id);

	List<StudyNode> selectShould();

	List<StudyNode> selectLatestNode(StudyNode studyNode);

	List<StudyNode> detailList(Long studyId);

	int updateByExampleSelective(@Param("record") StudyNode record, @Param("example") StudyNodeExample example);

	int updateByExample(@Param("record") StudyNode record, @Param("example") StudyNodeExample example);

	int updateByPrimaryKeySelective(StudyNode record);

	int updateByPrimaryKey(StudyNode record);

	int insertBatch(List<StudyNode> nodes);
}