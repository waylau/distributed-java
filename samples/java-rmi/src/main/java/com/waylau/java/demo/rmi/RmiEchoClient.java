/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI Echo Client.
 * 
 * @since 1.0.0 2020年1月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class RmiEchoClient {

	public static void main(String[] args) {
		try {
			String host = ServerConstant.HOST;
			int port = ServerConstant.PORT;
			
			Registry registry = LocateRegistry.getRegistry(host, port);
			Message stub = 
					(Message) registry.lookup(ServerConstant.REGIRTRY_NAME);
			String response = stub.echoMessage(ServerConstant.HELLO_WORLD);
			
			System.out.println("Server -> Client: " + response);
		} catch (Exception e) {
			System.err.println("RmiEchoClient exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
