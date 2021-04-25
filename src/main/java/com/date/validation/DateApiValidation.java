package com.date.validation;

import java.util.Scanner;

import com.date.validation.exception.DateValidationCheck;
import com.date.validation.exception.TimeValidationCheck;
 
import com.date.validation.utils.DateUtilsClass;


/**
 *
 * @author Anurag
 */
public class DateApiValidation {

	//Driver code 
	public static void main(String[] args) {
		
		System.out.println("Please Input the Date and Time in DD-MM-YYYY HH:MM:SS AM/PM Format");
		
		Scanner sc = new Scanner(System.in);
	
		String input = sc.nextLine();
		String[] dateInputText = input.split(" ");
		String dateTimeCaptured = dateInputText[0];

		//Travese the Tokens
		for (String a : dateInputText) {
			System.out.println(a);
		}
		
		//Separeate the tokens
		String dateInput[] = dateInputText[0].split("-");
		String timeInput = dateInputText[1];
		String dateFormat = dateInputText[2]; // AM OR PM

		try {
			DateUtilsClass.isValidDateCheck(Integer.parseInt(dateInput[0]), Integer.parseInt(dateInput[1]),Integer.parseInt(dateInput[2])); 
			System.out.println("Valid Date: " + dateTimeCaptured);
		}
		catch(DateValidationCheck dte) {
			System.out.println("Invalid Date: " + dateTimeCaptured);
		}
		
		System.out.println("Day of the week: " + DateUtilsClass.findDay(Integer.parseInt(dateInput[0]), Integer.parseInt(dateInput[1]), Integer.parseInt(dateInput[2])));
		
		try {
			System.out.println(DateUtilsClass.isValidTimeCheck(timeInput, dateFormat));
		} catch (TimeValidationCheck e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		//System.out.println("Is it leap year:" + DateUtils.isLeapYear(Integer.parseInt(dateInput[2])));
		sc.close();
	}
}
