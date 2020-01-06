package cn.itcast.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.abhs.domain.Study;
import cn.itcast.abhs.service.StudyService;
import cn.itcast.abhs.utils.Const;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class StudyTest {
	@Autowired
	private StudyService studyService;

	@Test
	public void save() {
		Study study = new Study();
		study.setName("代数第一节");
		study.setLearnedTime(new Date());
		study.setFinishStatus("学习中");
		studyService.save(study);
	}

	/**
	 * 
	 */
	@Test
	public void allTask() {
		Study study = new Study();
		study.setFinishStatus(Const.FINISH_STATUS_REVIEWYING);
		study.setName("鸡%");
		List<Study> allTask = studyService.allTask(study);
		for (Study s : allTask) {
			System.out.println(s);
		}
	}
}
