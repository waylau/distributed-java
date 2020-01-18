/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Message.
 * 
 * @since 1.0.0 2020年1月18日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface Message extends Remote {

	/**
	 * 发送消息.
	 * 
	 * @param msg 消息
	 * @return 响应内容
	 * @throws RemoteException
	 */
	String echoMessage(String msg) throws RemoteException;
}
