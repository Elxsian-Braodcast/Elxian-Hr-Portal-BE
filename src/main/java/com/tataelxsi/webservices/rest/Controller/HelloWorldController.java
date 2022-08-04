package com.tataelxsi.webservices.rest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tataelxsi.webservices.rest.model.HelloWorld;

//put it as rest controller

@RestController
public class HelloWorldController {

	// mapping what type of http method using
	// GET
	// URI = /TataElxsiHome
	// method = helloWorld

	@GetMapping(path = "/TataElxsiHome")
	public String helloWorld() {
		return "hello Tata Elxsi blessed me i will work for u forever ";

	}
	@GetMapping(path = "/TataElxsi-bean")
	
	public HelloWorld helloWorldBean() {
		
		return new HelloWorld("hello tata elxsi this is a bean creation plz allow my one");
		
	}
	@GetMapping(path = "/TataElxsi/pathvariable/{name}")
	public HelloWorld hellWorldVariablePath(@PathVariable String name) {
		return new HelloWorld(String.format("Hello TataElxsi, %s", name));
	}

}
