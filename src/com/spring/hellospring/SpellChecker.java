package com.spring.hellospring;

import org.springframework.beans.factory.annotation.Autowired;

public class SpellChecker {

	// 构造函数

	public SpellChecker() {
		System.out.println("Inside SpellChecker constructor");
	}

	// 内部的功能方法实现
	public void checkSpelling() {
		System.out.println("Inside checkSpelling.");

	}

}
