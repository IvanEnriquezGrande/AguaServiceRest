package com.itq.aguaService.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternsValidator {

	public static boolean nameValidation(String name) {
		return validation("^([A-Z][a-z]*\\s)*[A-Z][a-z]*$", name);
	}
	
	public static boolean emailValidation(String email) {
		return validation("^[\\w-]+@\\w+(.\\w+)+$", email);
	}

	
	public static boolean numberValidation(String number) {
		return validation("[0-9]{10}", number);
	}

	public static boolean validation(String pat, String str) {
	    Pattern pattern = Pattern.compile(pat);
	    Matcher matcher = pattern.matcher(str);
	    return matcher.find();
	}
}
