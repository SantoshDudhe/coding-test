package com.nisum.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * Test cases for Solution IMPL classes.
 * 
 * @author 91898
 *
 */
class SolutionImplTest {

	
	
	/**
	 * Method to test retrieve string from HTML tag.
	 */
	@Test
	void testRetriveStringFromHtmlTagWithHtmlTagAsInputList() {
		String expected="India is my country.\n" + 
				"COVID-19 is not over yet.\n" + 
				"Take care of you and others.\n" + 
				"Nisum is hiring Java developer.\n" + 
				"The Java developer should always follow best coding practices.";
		List<String> input = new ArrayList<String>();
		input.add("4");
		input.add("<h1>India is my country.</h1>");
		input.add("<h1><h1>COVID-19 is not over yet.</h1></h1><par>Take care of you and others.</par>");
		input.add("<Nisum>Nisum is hiring Java developer.</Nisum>");
		input.add("<java developer>The Java developer should always follow best coding practices.</java developer>");
		 
		SolutionImpl soulitionImpl = new SolutionImpl();
		
		String result=soulitionImpl.retriveStringFromHtmlTagWithHtmlTagAsInputList(input).stream().map(Object :: toString)
				 .collect(Collectors.joining("\n"));
		
		assertEquals(expected,result , "Test Case Failed");
		
		
	}
	


}
