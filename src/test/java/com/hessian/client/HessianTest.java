package com.hessian.client;

import java.net.MalformedURLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;
import com.caucho.hessian.client.HessianProxyFactory;
import com.hessian.service.client.IServlet;
import com.hessian.service.client.IUserService;
import com.hessian.service.common.RequestParam;
import com.hessian.service.common.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring.xml" })
public class HessianTest {

	@Autowired
	IUserService userService;
	
	@Test
	public void hessianTest() {
		
		String token = userService.generatorToken("liuzhiyong14");
		userService.setToken(token);
		
		String result = userService.hello("china");
		String json = JSONObject.toJSONString(userService.getById(3));

		RequestParam param = new RequestParam();
		param.setName("老四");
		param.setCard(123456);
		User user = userService.getUser(param);

		System.out.println(String.format("result is [%s]", result));
		System.out.println(String.format("json is [%s]", json));
		System.out.println(String.format("user is [%s]",JSONObject.toJSONString(user)));

	}

	@Test
	public void servletTest() {
		String url = "http://10.15.135.184:8080/hello";

		HessianProxyFactory factory = new HessianProxyFactory();
		try {
			IServlet servlet = (IServlet) factory.create(IServlet.class, url);
			String result = servlet.hello("china");

			String json = JSONObject.toJSONString(servlet.getById(3));

			RequestParam param = new RequestParam();
			param.setName("老四");
			User user = servlet.getUser(param);

			System.out.println(String.format("result is [%s]", result));
			System.out.println(String.format("json is [%s]", json));
			System.out.println(String.format("user is [%s]",JSONObject.toJSONString(user)));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
