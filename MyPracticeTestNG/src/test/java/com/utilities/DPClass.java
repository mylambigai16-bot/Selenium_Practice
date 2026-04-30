package com.utilities;

import org.testng.annotations.DataProvider;

public class DPClass {
	
	@DataProvider(name="valid",parallel=true)
	public Object[][] validdata(){
		return new Object[][] {
			arrObj[][];
		}
	}
	@DataProvider(name="Invalid",parallel=true)
	public Object[][] invaliddata(){
		return new Object[][] {
			arrObj[][];
		}
	}

}
