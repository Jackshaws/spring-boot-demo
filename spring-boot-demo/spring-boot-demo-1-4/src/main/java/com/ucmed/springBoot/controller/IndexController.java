package com.ucmed.springBoot.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ucmed.springBoot.bean.User;
@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableScheduling
@RestController
@RequestMapping("/index")
public class IndexController {

	@Value(value = "${roncoo.secret}")
	private String secret;

	@Value(value = "${roncoo.number}")
	private int number;

	@Value(value = "${roncoo.descr}")
	private String desc;

	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "hello World";
	}

	// @RequestParam 简单类型的绑定，可以出来get和post
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public HashMap<String, Object> get(@RequestParam(name="name") String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "hello world");
		map.put("name", name);
		map.put("secret", secret);
		map.put("number", number);
		map.put("desc", desc);
		return map;
	}

	// @PathVariable 获得请求url中的动态参数
	@RequestMapping(value="/get/{id}/{name}",method = RequestMethod.GET)
	public User getUser(@PathVariable int id, @PathVariable String name) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setDate(new Date());
		return user;
	}
}
