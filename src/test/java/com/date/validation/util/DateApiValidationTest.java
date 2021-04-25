package com.date.validation.util.date_api_validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.date.validation.exception.DateValidationCheck;
import com.date.validation.exception.TimeValidationCheck;
import com.date.validation.utils.DateUtilsClass;
import com.date.validation.utils.DateUtilsClassForWords;
 

public class DateApiValidationTest {
   
    @Test
    public void testLeapYear() {
        new DateUtilsClass(2000, 2, 28);
		assertTrue(DateUtilsClass.isLeapYear(2000));
        new DateUtilsClass(2004, 1, 31);
		assertTrue(DateUtilsClass.isLeapYear(2004));
        new DateUtilsClass(2008, 3, 30);
		assertTrue(DateUtilsClass.isLeapYear(2008));
        new DateUtilsClass(1996, 6, 8);
		assertTrue(DateUtilsClass.isLeapYear(1996));
        new DateUtilsClass(1600, 9, 2);
		assertTrue(DateUtilsClass.isLeapYear(1600));
        new DateUtilsClass( 400, 1, 8);
		assertTrue(DateUtilsClass.isLeapYear(400));
        new DateUtilsClass(160000, 2, 28);
		assertTrue(DateUtilsClass.isLeapYear(160000));
        
    }
    
    @Test
    public void testNonLeapYearNone() {
        new DateUtilsClass(1999, 2, 28);
		assertFalse(DateUtilsClass.isLeapYear(1999));
        new DateUtilsClass(1, 2, 28);
		assertFalse(DateUtilsClass.isLeapYear(1));
        new DateUtilsClass(5, 2, 28);
		assertFalse(DateUtilsClass.isLeapYear(5));
        new DateUtilsClass(-3, 2, 28);
		assertFalse(DateUtilsClass.isLeapYear(5));
        new DateUtilsClass(Integer.MAX_VALUE, 2, 28);
		assertFalse(DateUtilsClass.isLeapYear(Integer.MAX_VALUE));
    }
    
    
    @Test
    public void testValidDatecheck() throws DateValidationCheck {
     
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(2, 2, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(3, 3, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(4, 4, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(5, 5, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(6, 6, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(7, 7, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(8, 8, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(9, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(10, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
         assertEquals(true, DateUtilsClass.isValidDateCheck(1, 1, 2021));
               
         assertNotEquals("Invalid Month ", DateUtilsClass.isValidDateCheck(21,15,2012));
         assertNotEquals("Invalid Year", DateUtilsClass.isValidDateCheck(10, 10, 200));
         assertNotEquals("Invalid Day", DateUtilsClass.isValidDateCheck(33, 10, 200));
         assertNotEquals("Invalid Year", DateUtilsClass.isValidDateCheck(10, 10, -200));
         assertNotEquals("Invalid Year", DateUtilsClass.isValidDateCheck(10, 10, 0));
         assertNotEquals("Invalid Date", DateUtilsClass.isValidDateCheck(45, 10, 1100));
       
    }
    
    @Test
    public void testValidTimecheck() throws DateValidationCheck, TimeValidationCheck {
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("06:07:10", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("00:07:10", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("11:07:10", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("1:29:23", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("23:57:59", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("01:07:10", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("02:07:10", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("17:07:10", "PM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("15:29:23", "PM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("23:57:59", "AM"));
    	assertEquals(true, DateUtilsClass.isValidTimeCheck("16:07:10", "PM"));
   
    	
    	//Checking AM/PM Format , min, sec, hours
    	assertNotEquals("Invalid time PM", DateUtilsClass.isValidTimeCheck("01:07:10", "PM"));
    	assertNotEquals("Invalid time AM", DateUtilsClass.isValidTimeCheck("25:07:10", "AM"));
    	assertNotEquals("Invalid time minutes", DateUtilsClass.isValidTimeCheck("17:67:10", "PM"));
    	assertNotEquals("Invalid time Seconds",  DateUtilsClass.isValidTimeCheck("15:29:110", "PM"));
    	assertNotEquals("Invalid time AM", DateUtilsClass.isValidTimeCheck("21:09:59", "AM"));
    	assertNotEquals("Invalid time AM", DateUtilsClass.isValidTimeCheck("16:07:10", "AM"));
    	assertNotEquals("Invalid time Hour", DateUtilsClass.isValidTimeCheck("25:07:10", "AM"));
    	assertNotEquals("Invalid time Hour", DateUtilsClass.isValidTimeCheck("24:07:10", "AM"));
   
 }
    @Test
    public void testDayofTheWeek() throws DateValidationCheck, TimeValidationCheck {
    	assertEquals("Sunday", DateUtilsClass.findDay(25, 4, 2021));
    	assertEquals("Monday", DateUtilsClass.findDay(26, 4, 2021));
    	assertEquals("Tuesday", DateUtilsClass.findDay(27, 4, 2021));
    	assertEquals("Wednesday",DateUtilsClass.findDay(28, 4, 2021));
    	assertEquals("Thursday", DateUtilsClass.findDay(29, 4, 2021));
    	
    	assertNotEquals("Monday", DateUtilsClass.findDay(25, 4, 2021));
    	assertNotEquals("Sunday", DateUtilsClass.findDay(26, 4, 2021));
    	assertNotEquals("Sunday", DateUtilsClass.findDay(29, 4, 2020));
    	
    	
    }
    
    @Test
    public void testDatetowords() throws DateValidationCheck, TimeValidationCheck {
    	//dd mm yyyy
    	DateUtilsClassForWords dateObj= new DateUtilsClassForWords();
    	String valDay= dateObj.convert(25);
    	String valMonth=dateObj.getMonth(1);
    	String valYear= dateObj.convert(2021);
    	String finalConversion= valDay+" "+ valMonth+" "+valYear;
    	assertEquals("twenty five JAN two thousand and twenty one", finalConversion );
    	
    }
    	
    }