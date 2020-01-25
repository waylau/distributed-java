/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.ws;

import javax.xml.ws.Endpoint;

/**
 * Hello Publisher.
 * 
 * @since 1.0.0 2020年1月25日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HelloPublisher {
	public static void main(String[] args) {

		Endpoint.publish("http://localhost:9999/ws/hello", 
				new HelloServiceImpl());

	}
}
