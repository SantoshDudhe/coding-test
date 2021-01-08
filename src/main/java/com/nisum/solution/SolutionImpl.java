package com.nisum.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 * @author Santosh Dudhe
 *
 */
public class SolutionImpl implements Solution {

	/**
	 * Scanner object.
	 */
	private Scanner scan;

	/**
	 * Method to retrieve data from HTML tag.
	 * 
	 * @param tags HTML tag value.
	 * @return list of string.
	 */
	private List<String> retriveString(String tags) {
		List<String> resultList = new ArrayList<String>();
		Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
		 boolean matchFound = false;
		Matcher m = r.matcher(tags);
		while (m.find()) {
			resultList.add(m.group(2));
		}
		if ( ! matchFound) {
			resultList.add("None");
        }
		return resultList;
	}

	/**
	 *Method receive list of tag as input, first element in the list is no of item in list.
	 * 
	 * @param inputTags
	 * @return list of string.
	 */
	public List<String> retriveStringFromHtmlTagWithHtmlTagAsInputList(List<String> inputTags) {

		if (Integer.parseInt(inputTags.get(0)) != inputTags.size()) {
			throw new RuntimeException("Invalid input");
		}
		List<String> finalResult = new ArrayList<String>();
		for (int i = 1; i < inputTags.size(); i++) {
			finalResult.addAll(retriveString(inputTags.get(i)));
		}
		return finalResult;
	}

	/**
	 * Method which read input from user at runtime.
	 * 
	 * @return list of string.
	 */
	public List<String> retriveStringFromHtmlTagReadInputAtRuntime() {

		scan = new Scanner(System.in);
		System.out.println("Enter no of line");
		int testCases = Integer.parseInt(scan.nextLine());
		List<String> finalResult = new ArrayList<String>();
		while (testCases-- > 0) {
			System.out.println("Enter Tag");
			String line = scan.nextLine();
			finalResult.addAll(retriveString(line));
		}
		System.out.println(finalResult.stream().map(Object :: toString)
				 .collect(Collectors.joining("\n")));
		return finalResult;
	}
}
