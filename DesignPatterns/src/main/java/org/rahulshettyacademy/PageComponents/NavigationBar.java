package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponent.AbstractComponent;

public class NavigationBar extends AbstractComponent
{
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);
    }
    public String  getFlightAttribute()
    {
        return  findElement(flights).getAttribute("class");
        //driver.findElement(flights).click();
    }
    public int getLinksCount()
    {
        return findElements(links).size();
    }
}
