package com.xiaoi.dev.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.eastrobot.robotface.domain.RobotCommand;

@XmlRootElement(name = "robotResponse")
public class RobotResponse {

	private int type = -1;
	private String content;
	private String nodeId;
	private String moduleId;
	private String[] tags;
	private float similarity;
	private RobotCommand[] commands;
	private String[] relatedQuestions;

	// 一般为Map或者为List<Map>
	private Object attachment;
	// 人工状态标识
	private String acsStatus;

	public String getAcsStatus() {
		return acsStatus;
	}

	public void setAcsStatus(String acsStatus) {
		this.acsStatus = acsStatus;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public float getSimilarity() {
		return similarity;
	}

	public void setSimilarity(float similarity) {
		this.similarity = similarity;
	}

	public RobotCommand[] getCommands() {
		return commands;
	}

	public void setCommands(RobotCommand[] commands) {
		this.commands = commands;
	}

	public String[] getRelatedQuestions() {
		return relatedQuestions;
	}

	public void setRelatedQuestions(String[] relatedQuestions) {
		this.relatedQuestions = relatedQuestions;
	}

	public Object getAttachment() {
		return attachment;
	}

	public void setAttachment(Object attachment) {
		this.attachment = attachment;
	}

}
