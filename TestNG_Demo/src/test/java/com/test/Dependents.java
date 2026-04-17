package com.test;

import org.testng.annotations.Test;

public class Dependents {
  @Test(groups="smoke")
  public void D() {
	  System.out.println("First");
  }
  @Test(groups="regression")
  public void C() {
	  System.out.println("Second");
  }
  @Test(groups="")
  public void B() {
	  System.out.println("Third");
  }
  @Test(dependsOnGroups="smoke")
  public void A() {
	  System.out.println("Fourth");
  }
}
