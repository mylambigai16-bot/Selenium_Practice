package com.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {

        return new Object[][]{
                {"pavanol", "test123"},
                {"wronguser", "wrongpass"}
        };
    }
}