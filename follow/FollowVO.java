package week11;

import java.io.Serializable;
import java.sql.Date;

public class FollowVO implements Serializable{
	
	private Integer followID;
	private Integer sourceID;
	private Integer targetID;
	private String updatedAt;
	
	
	public FollowVO() {
		super();
	}

	public FollowVO(Integer followID, Integer sourceID, Integer targetID, String updatedAt) {
		super();
		this.followID = followID;
		this.sourceID = sourceID;
		this.targetID = targetID;
		this.updatedAt = updatedAt;
	}
	
	public FollowVO(Integer sourceID, Integer targetID) {
		super();
		this.sourceID = sourceID;
		this.targetID = targetID;
	}

	public Integer getFollowID() {
		return followID;
	}

	public void setFollowID(Integer followID) {
		this.followID = followID;
	}

	public Integer getSourceID() {
		return sourceID;
	}

	public void setSourceID(Integer sourceID) {
		this.sourceID = sourceID;
	}

	public Integer getTargetID() {
		return targetID;
	}

	public void setTargetID(Integer targetID) {
		this.targetID = targetID;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
