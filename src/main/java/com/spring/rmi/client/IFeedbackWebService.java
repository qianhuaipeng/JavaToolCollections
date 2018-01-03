package com.spring.rmi.client;

import java.rmi.RemoteException;

public interface IFeedbackWebService {
	/**

	 * <b>方法用途和描述:</b> 客户反馈RMI服务端接口方法<br>
	 * <b>方法的实现逻辑描述：</b> 通过RMI提供服务，Spring支持的RMI远程调用
	 */
	public boolean setFeedback(String systemID, String feedbackType, String feedbackContent) throws RemoteException ;
}
