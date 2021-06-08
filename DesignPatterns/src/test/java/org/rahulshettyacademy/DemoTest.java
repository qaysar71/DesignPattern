package org.rahulshettyacademy;


import org.openqa.selenium.WebDriver;

import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest
{
     WebDriver driver;
    TravelHomePage travelHomePage;

     @BeforeTest
     public void setUp()
     {
         driver = InitializeDriver();


          travelHomePage = new TravelHomePage(driver);
     }

@Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String>reservationDetails)
{

    travelHomePage.goTo();
    System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
    System.out.println( travelHomePage.getNavigationBar().getFlightAttribute());
    System.out.println(travelHomePage.getFooterNav().getLinksCount());
    System.out.println(travelHomePage.getNavigationBar().getLinksCount());
    travelHomePage.setBookingStrategy("multitrip");



    travelHomePage.checkAvail(reservationDetails);

}

@DataProvider
    public Object[][] getData() throws IOException
{
    List<HashMap<String, String>>l = getJsonData(System.getProperty("user.dir")+"/src/main/java/org/rahulshettyacademy/dataLoads/reservationDetails.json");

    return new Object[][]
            {
                    {l.get(0)}, {l.get(1)}
            };
}

@AfterTest
    public void tearDown()
{
    driver.quit();
}

}


