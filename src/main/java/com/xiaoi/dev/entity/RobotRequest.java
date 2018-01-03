/**    
 * 文件名：RobotRequest.java    
 *
 * 版本信息：    
 * 日期：2016年1月30日    
 * create by ziQi       
 * 2016年1月30日
 */
package com.xiaoi.dev.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @title RobotRequest
 * @description 请求对象
 * @author ziQi
 * @version 上午10:40:00
 * @create_date 2016年1月30日上午10:40:00
 * @copyright (c) jacky
 */
@XmlRootElement(name = "robotRequest")
public class RobotRequest {

	private String sessionId;

	private String userId;

	private String question;

	private String[] tags;

	private String[] modules;

	private int maxReturn;

	private String attributes;

	private String platform;

	private String brand;

	private String location;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String[] getModules() {
		return modules;
	}

	public void setModules(String[] modules) {
		this.modules = modules;
	}

	public int getMaxReturn() {
		return maxReturn;
	}

	public void setMaxReturn(int maxReturn) {
		this.maxReturn = maxReturn;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

}
