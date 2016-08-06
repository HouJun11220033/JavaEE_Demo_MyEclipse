package com.spring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TextEditorConfig {
	@Bean
	public TextEditor textEditor() {
		return new TextEditor(spellChecker());
	}

	@Bean
	// 让spellChecker这个方法返回SpellChecker()这个构造方法
	public SpellChecker spellChecker() {
		return new SpellChecker();
	}

}
