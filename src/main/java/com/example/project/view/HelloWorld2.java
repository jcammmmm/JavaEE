package com.example.project.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
//@FacesConfig // FIX javax.el.PropertyNotFoundException: /hello.xhtml @14,67 value="#{helloWorld.input}": Target Unreachable, identifier 'helloWorld' resolved to null
@Named // gives the bean a name, which is primarily used to reference it via EL
@RequestScoped // lifespan is the duration of an HTTP request
public class HelloWorld2 {
	private String input;
	private String output = "HW.output_default_string";
	
	public void submit() {
		output = "Hello World! You have typed: " + input;
		for(int i = 0; i < 10; i++) {
			double d = i*i;
			d = d + d;
		}
	}
	
	public void echo() {
		System.out.println("buahahahha");
	}

	public String getInput() {
		return input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public String getOutput() {
		return output;
	}

}
