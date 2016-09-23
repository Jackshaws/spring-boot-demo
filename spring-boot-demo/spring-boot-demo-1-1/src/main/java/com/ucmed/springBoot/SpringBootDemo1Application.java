package com.ucmed.springBoot;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ucmed.springBoot.bean.User;
/**
 * RESTfull api 简单项目的快速搭建
 * @author ucmed
 *
 */
@SpringBootApplication
@RestController
public class SpringBootDemo1Application {
	@RequestMapping("/main")
	    public String greeting() {
	        return "Hello World!";
	    }
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
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo1Application.class, args);
	}

}
