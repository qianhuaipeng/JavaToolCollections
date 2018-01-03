package com.spring.rmi.server;

import java.rmi.RemoteException;

public interface IFeedbackWebService {
	/**

	 * <b>方法用途和描述:</b> 客户反馈RMI服务端接口方法<br>

	 * <b>方法的实现逻辑描述：</b> 通过RMI提供服务，Spring支持的RMI远程调用

	 * @param systemID : 业务系统的唯一标识

	 * @param feedbackType ：用户反馈的类型（1-系统BUG、2-系统易用性、3-客服人员态度、4-运维人员态度、5-其他）

	 * @param feedbackContent ：用户反馈的正文内容

	 * @return 反馈是否成功 true | false

	 */

	public boolean setFeedback(String systemID, String feedbackType, String feedbackContent) throws RemoteException ;
}
