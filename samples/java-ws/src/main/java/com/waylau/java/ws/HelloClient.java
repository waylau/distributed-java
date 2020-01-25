/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.ws;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Hello Client.
 * 
 * @since 1.0.0 2020年1月25日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HelloClient {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:9999/ws/hello?wsdl");
		QName qname = new QName("http://ws.java.waylau.com/", 
				"HelloServiceImplService");

		Service service = Service.create(url, qname);

		HelloService hello = service.getPort(HelloService.class);
		System.out.println(hello.getHelloworld());

	}

}
