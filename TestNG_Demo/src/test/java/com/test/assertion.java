package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class assertion {
  @Test
  public void AssertionDemo() {
	  String str1=new String("TestNG");
	  String str2=new String("TestNG");
	  String str3=null;
	  String str4="TestNG";
	  String str5="TestNG";
	  String str6=new String("Not TestNG");
	  int v1=5;
	  int v2=6;
	  Assert.assertEquals(str1, str2);
	  System.out.println("Equals is Successsful");
	  Assert.assertNotEquals(str1,str6);
	  System.out.println("Not equals is Successful");
	  Assert.assertTrue(v1<v2);
	  System.out.println("True Assert is Successful");
	  Assert.assertFalse(v1>v2);
	  System.out.println("FAlse assertion is successful");
	  Assert.assertNotNull(str1);
	  System.out.println("Not null Assertion is successful");
	  Assert.assertNull(str3);
	  System.out.println("Null Assertion is successful");
	  Assert.assertSame(str4, str5);
	  System.out.println("Same Assertiomn is Successful");
	  Assert.assertNotSame(str1,str3);
	  System.out.println("Not same Assertion is successful");
	  
  }
}
