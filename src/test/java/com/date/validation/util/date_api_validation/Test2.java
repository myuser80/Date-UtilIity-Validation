package com.date.validation.util.date_api_validation;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

/**
 * JUnit5AssertNotEqualsExample
 * @author javaguides.net
 *
 */
public class Test2 {
 public static String method1() {
  return null;
 }

 public static String method2() {
  return "Ramesh";
 }
 
 public static String method3() {
  return "Fadatare";
 }
 
 @Test
 public void assertNotEqualsTest() {
  assertNotEquals("null", method1());
  assertNotEquals("ramesh", method2());
  assertNotEquals("fadatare", method3());
 }
}