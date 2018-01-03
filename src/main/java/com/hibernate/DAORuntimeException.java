package com.hibernate;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 13, 2015 12:16:43 PM
 * @version 1.0
 */
public class DAORuntimeException extends RuntimeException {

	/**
	 * 
	 */
	public DAORuntimeException() {
	}

	/**
	 * @param message
	 */
	public DAORuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DAORuntimeException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DAORuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

}
