/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 * 
 * @since 1.0.0 2020年1月25日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@WebService(endpointInterface = "com.waylau.java.ws.HelloService")
public class HelloServiceImpl implements HelloService {

   @WebMethod
   public String getHelloworld() {
      return "Hello world!";
   }

}
