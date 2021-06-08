package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponent.SearchFlightsAvail;
import org.rahulshettyacademy.AbstractComponent.StrategyFactor;
import org.rahulshettyacademy.PageComponents.FooterNav;
import org.rahulshettyacademy.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage
{
    WebDriver driver;
    SearchFlightsAvail searchFlightsAvail;

    By sectionElement =   By.id("traveller-home");
    By NavSectionElement = By.id("buttons");

    public TravelHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public  void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
    }

    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver,NavSectionElement);
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,sectionElement);
    }

    public void setBookingStrategy(String  strategyType)
    {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightsAvail = strategyFactor.createStrategy(strategyType);



    }
    public void checkAvail(HashMap<String,String> reservationDetails)
    {

        searchFlightsAvail.checkAvail(reservationDetails);
    }
}
