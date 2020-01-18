/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * RMI Echo Server.
 * 
 * @since 1.0.0 2020年1月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class RmiEchoServer implements Message {
	
	@Override
	public String echoMessage(String msg) throws RemoteException {
		System.out.println("Client -> Server: " + msg);
		return msg;
	}
	
	public static void main(String args[]) {
		
		try {
			int port = ServerConstant.PORT;
			
			RmiEchoServer obj = new RmiEchoServer();
		    Message stub = (Message) UnicastRemoteObject.exportObject(obj, 0);

		    // 绑定远程对象的stub到注册中心
		    Registry registry = 
		    		LocateRegistry.getRegistry(port); // 如不指定端口，默认使用1099
		    registry.rebind(ServerConstant.REGIRTRY_NAME, stub);

		    System.err.println("RmiEchoServer started on port: " + port);
		} catch (Exception e) {
		    System.err.println("RmiEchoServer exception: " + e.toString());
		    e.printStackTrace();
		}
	    }

}
