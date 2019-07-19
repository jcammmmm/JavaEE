package com.example.project.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named // gives the bean a name, which is primarily used to reference it via EL
@RequestScoped // lifespan is the duration of an HTTP request
public class HelloWorld {
	private String input;
	private String output;
	
	public void submit() {
		output = "Hello World! You have typed: " + input;
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
