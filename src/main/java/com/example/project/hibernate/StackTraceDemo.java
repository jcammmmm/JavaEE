package com.example.project.hibernate;

import java.io.*;

public class StackTraceDemo {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("my.txt");
			// System.out.println(8/0);
			pw.write("hello");
		} 
		catch (ArithmeticException ex) {
			System.out.println("catch");
		}
		finally {
			pw.close();
			System.out.println("finally buu");
		}
		TestClass.doException();
	}
	
	public static void methodA() {
		methodB();
	}
	
	public static void methodB() {
		methodC();
	}

	public static void methodC() {
		System.out.println(1/0);
	}
	
	public static class TestClass {
		public static void doException() {
			StackTraceDemo.methodA();
		}
	}
}


