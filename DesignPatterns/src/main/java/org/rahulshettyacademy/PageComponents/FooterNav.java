package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponent.AbstractComponent;

public class FooterNav extends AbstractComponent
{
    WebDriver driver;


  By flights = By.cssSelector("[title='Flights']");
  By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement)
    {
        super(driver, sectionElement);

    }

    //method to handle Flights
    //when selenium execute any method in this class - scope of selenium should be in the footer only
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
