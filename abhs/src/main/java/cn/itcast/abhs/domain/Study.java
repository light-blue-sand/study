package cn.itcast.abhs.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Study {
	private Long id;

	private String name;

	private Date learnedTime;

	private String finishStatus;

	private Date finishTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Date getLearnedTime() {
		return learnedTime;
	}

	public void setLearnedTime(Date learnedTime) {
		this.learnedTime = learnedTime;
	}

	public String getFinishStatus() {
		return finishStatus;
	}

	public void setFinishStatus(String finishStatus) {
		this.finishStatus = finishStatus == null ? null : finishStatus.trim();
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	@Override
	public String toString() {
		String dateStr = null;
		if (learnedTime != null) {
			dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(learnedTime);
		}
		String str = "Study [id=" + id + ", name=" + name + ", learnedTime=" + dateStr + ", finishStatus="
				+ finishStatus + ", finishTime=" + finishTime + "]";
		return str;
	}
}