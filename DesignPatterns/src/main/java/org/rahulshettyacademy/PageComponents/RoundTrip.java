package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponent.AbstractComponent;
import org.rahulshettyacademy.AbstractComponent.SearchFlightsAvail;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements SearchFlightsAvail
{

    By rdo=  By.id("ctl00_mainContent_rbtnl_Trip_1");
    By from =By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By cb = By.id("ctl00_mainContent_chk_IndArm");
    By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails)
    {
     findElement(rdo).click();
     findElement(from).click();
     selectOriginCity(reservationDetails.get("origin"));
     selectDestinationCity(reservationDetails.get("destination"));
     findElement(cb).click();
     findElement(search).click();


    }

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
