package com.spring.hellospring;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	// @Autowired
	private SpellChecker spellChecker;

	// private String name;
	// 没有显示得调用get方法
	//
	// public String getName() {
	// return name;
	// }
	//
	// public void setName(String name) {
	// this.name = name;
	// }
	//
	// @Autowired
	//
	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
	}

	// public SpellChecker getSpellChecker() {
	// System.out.println("Inside getSpellChecker.");
	// //return:获得spellChecker的构造方法，和其他方法
	// return spellChecker;
	// }
	// @Autowired//@Autowired on Setter Methods
	// @Resource(name= "spellChecker")
	// public void setSpellChecker(SpellChecker spellChecker) {
	// //System.out.println("Inside setSpellChecker.");
	// this.spellChecker = spellChecker;
	// }

	// 只负责invoke就行
	public void spellCheck() {
		spellChecker.checkSpelling();
	}

}
