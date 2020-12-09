package org.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

	List<Integer> negativeNumbers = new ArrayList<Integer>();
	private static int MAX_NUMBER = 1000;

	public int add(String numbers) throws Exception {
		int sum = 0;
		if (isNullOrEmpty(numbers)) {
			return sum;
		} else {
			sum = doSumOrPrintNegativeNumbers(numbers, sum);
			if(negativeNumbers.size()>0) {
				throw new Exception("Numbers cannot be negative "+negativeNumbers.toString());
			}
		}
		return sum;
	}

	private int doSumOrPrintNegativeNumbers(String numbers, int sum) {
		for (String str : identifyNumbersFromString(numbers)) {
			int value = Integer.valueOf(str);
			if(value >= MAX_NUMBER){
				continue;
			}else if(value > 0) {
				sum += value;
			}else {
				negativeNumbers.add(value);
			}
		}
		return sum;
	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public List<String> identifyNumbersFromString(String str) {
		return Arrays.asList(str.replaceAll("[^-?0-9]+", " ")
				.trim()
				.split(" "));
	}

}
