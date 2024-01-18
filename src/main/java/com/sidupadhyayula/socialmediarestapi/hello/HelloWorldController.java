package com.sidupadhyayula.socialmediarestapi.hello;

import java.util.Locale;

import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController (MessageSource messageSource) {
		this.messageSource = messageSource;
		
	}
	
	@GetMapping(path = "/helloworld")
	public String HelloWorld(){
		return "Hello World";
	}

	@GetMapping(path = "/helloworldbean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/helloworldbean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean("Hello World, " + name);
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String HelloWorldInternationalized(){
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}
}
