package com.test;

import org.testng.annotations.DataProvider;

public class DPClassDemo {
  
  @DataProvider(name="dp")
  public Object[][] dataproviderFunc() {
      return new Object[][] {
          {"mylu","myl"},
          {"myl","myl0616"}
      };
  }
  @DataProvider(name="dp1")
  public Object[][] DPFunc1(){
	  return new Object[][] {
		  {"Chrome","https://www.demoblaze.com/"}
	  };
  }

}
