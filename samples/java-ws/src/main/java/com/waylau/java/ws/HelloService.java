/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.ws;

import javax.jws.WebService;

/**
 * Hello Service.
 * 
 * @since 1.0.0 2020年1月25日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@WebService
public interface HelloService {
	String getHelloworld();
}
