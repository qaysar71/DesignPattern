package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponent.AbstractComponent;
import org.rahulshettyacademy.AbstractComponent.SearchFlightsAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightsAvail
{
    By modalPopUp = By.id("MultiCityModelAlert");
    By multicity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    By destination_2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
   // By submit = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails)
    {
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));

        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
        // findElement(submit).click();


    }

    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='" + destination2 + "'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        // common prerequests code

        System.out.println("I am inside multitrip");
        findElement(multicity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("I am done");

        //execute actual function-book/calendar
        //tear down method
    }

}


