package com.spring.rmi.server;

import java.io.Serializable;
import java.rmi.RemoteException;

public class FeedbackWebServiceImpl implements IFeedbackWebService, Serializable {

	@Override
	public boolean setFeedback(String systemID, String feedbackType,
			String feedbackContent) throws RemoteException {
		System.out.println(systemID + "|" + feedbackType + "|"
				+ feedbackContent);
		return false;
	}

}
