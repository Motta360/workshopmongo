package com.lucasmotta.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class URL {

	public static String decodeParam(String text) {

		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	
	public static LocalDate convertDate(String text, LocalDate defaultDate) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			return LocalDate.parse(text,fmt);
		} catch (Exception e) {
			return LocalDate.now();
		}
		
	}
}
