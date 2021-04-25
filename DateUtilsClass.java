package com.date.validation.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.date.validation.exception.DateValidationCheck;
import com.date.validation.exception.TimeValidationCheck;

/**
 *
 * @author Anurag
 */
public class DateUtilsClass {

	private int day;
	private int month;
	private int year;
	
	
	public DateUtilsClass(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public DateUtilsClass() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	static int MAX_VALID_YR = 9999;
	static int MIN_VALID_YR = 1800;

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 4 == 0)
			return true;
		return false;
	}

	public static boolean isLeap(int year) {
		// Return true if year is
		// a multiple of 4 and not
		// multiple of 100.
		// OR year is multiple of 400.
		if ((year % 4 == 0 && year % 100 != 0) || year % 4 == 0)
			return true;
		return false;

	}


	// Returns true if d is in format
	// dd-mm-yyyy
	public static boolean isValidDateUsingRegEx(String d)
	{
		String regex=	"^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence)d);
		return matcher.matches();
	}

	
	public static boolean isValidDateCheck(int d, int m, int y) throws DateValidationCheck {

		// If year, month and day // are not in given range

		if (y > MAX_VALID_YR || y < MIN_VALID_YR) {

			//throw new DateValidationCheck("Invalid Date");
			return false;
		}
		if (m < 1 || m > 12) {
			//throw new DateValidationCheck("Invalid Date");
			 return false;
		}
		if (d < 1 || d > 31) {
			//throw new DateValidationCheck("Invalid Date");
			 return false;
		}

		// Handle February month // with leap year
		if (m == 2) {
			if (isLeap(y))
				return (d <= 29);
			else
				return (d <= 28);
		}

		// Months of April, June, // Sept and Nov must have // number of days less than
		// // or equal to 30.
		if (m == 4 || m == 6 || m == 9 || m == 11)
			return (d <= 30);

		return true;

	}

	// Zeller's congruence
	public static String findDay(int d, int m, int y) {
		int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
		y -= (m < 3) ? 1 : 0;
		int day = (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
		return returnDayName(day);

	}

	public static String returnDayName(int num) {
		String day = "";
		switch (num) {
		case 0:
			day = "Sunday";
			break;
		case 1:
			day = "Monday";
			break;
		case 2:
			day = "Tuesday";
			break;
		case 3:
			day = "Wednesday";
			break;
		case 4:
			day = "Thursday";
			break;
		case 5:
			day = "Friday";
			break;
		case 6:
			day = "Saturday";
			break;
		}
		return day;
	}

	public static boolean isValidTimeCheck(String time, String Format) throws TimeValidationCheck {

		String plu = null, a, plusec = null;
		String[] arr = time.split(":");
        String AM_or_PM = null;  
		String words[] = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
				"Twenty", "Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five", "Twenty six",
				"Twenty seven", "Twenty eight", "Twenty nine", "thirty", "thirty-one", " thirty-two", "thirty-three",
				"thirty-four", "thirty-five", "thirty-six", " thirty-seven", "thirty-eight", "thirty-nine", "forty",
				"forty-one", "forty-two", "forty-three", "forty-four", "forty-five", "forty-six", "forty-seven",
				"forty-eight", "forty-nine", "fifty", "fifty-one", "fifty-two", "fifty-three", "fifty-four",
				"fifty-five", "fifty-six", "fifty-seven", " fifty-eight", "fifty-nine" };

		// Parsing hours, minutes and seconds in array
		// Converting hours into integer
		int h = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int s = Integer.parseInt(arr[2]);

		if (Format.equalsIgnoreCase("AM")) 	AM_or_PM = "Morning";
		else if (Format.equalsIgnoreCase("PM")) AM_or_PM = "Evening";
		
		if (m == 1)
			plu = "Minute";
		else
			plu = "Minutes";

		if (s == 1)
			plusec = "Second";
		else
			plusec = "Seoncds";
		
		if (h < 12 && Format.equalsIgnoreCase("PM")) 
		{
			System.out.println("Invalid time " + time + " " + AM_or_PM);
		}	
		
		else if (h < 24 && h > 12  && Format.equalsIgnoreCase("AM")) 
		{
			System.out.println("Invalid time" + time + " " + AM_or_PM);
		}	
		else if ((h >= 0 && h <= 12) && (m >= 0 && m <= 59) && (s >= 0 && s <= 59)) 
		{
			if (h == 12)
				a = words[1]; // storing 'one' when hour is 12
			else
				a = words[h + 1]; // if hour is not 12, then storing in words, an hour ahead of given hour

			// The below code checks minutes and accordingly prints the time in words using
			// array.

			// System.out.println("Output : " + h + ":" + m + ":" + s); // printing the
			// given time in numbers

			if (m == 0)
				System.out
						.println(words[h] + " Hours  " + words[m] + " " + plu + words[s] + " " + plusec + " " + Format);
			else if (m == 15)
				System.out.println("Quarter " + words[h]);
			else if (m == 30)
				System.out.println("Half " + words[h]);
			else if (m == 45)
				System.out.println("Quarter" + a);
			else if (m < 30) // condition for minutes between 1-29
				// System.out.println(words[m] + " " + plu + " past " + words[h]);
				System.out.println("Valid time " + words[h] + " Hours " + words[m] + " " + plu + words[s] + " "
						+ plusec + " " + AM_or_PM);

			else if(m<=59 || s <=59) // condition for minutes between 31-59
					// System.out.println(words[60 - m] + " " + plu + " to " + a + " Hour");
					// System.out.println(" Time is " + words[h] + " Hours " + words[m] + " " + plu
					// + " " + words[s] + " " +plusec);

				System.out.println("Valid time " + words[h] + " Hours " + words[m] + " " + plu + "  " + words[s] + " "
						+ plusec + " " + AM_or_PM);
		} 
		// end of outer if
		
			else if ((h >= 12 && h <= 24) && (m >= 0 && m <= 59) && (s >= 0 && s <= 59)) {
				System.out.println("Valid time " + words[h] + " Hours " + words[m] + " " + plu + "  " + words[s] + " "
						+ plusec + " " + AM_or_PM);
			}
			else {
				System.out.println("InValid time "  +time + " " + AM_or_PM);
			}

		
			return true;
		
	}

	
}

