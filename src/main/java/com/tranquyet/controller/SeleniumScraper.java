package com.tranquyet.controller;

import com.tranquyet.dto.MenuItemDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumScraper {
    public static void main(String[] args) {
        // Set up WebDriver (Make sure to set the correct path for your driver)
        System.setProperty("webdriver.chrome.driver", "D:\\projects\\ai-module\\driver\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://xfilter.vn/");

        // Find elements with class "submenu__item"
        List<WebElement> submenuItems = driver.findElements(By.className("submenu__item"));
        String classContentMain = "submenu__item--main";
        String text = "";
        String parContent = "";
        for (WebElement submenuItem : submenuItems) {

            MenuItemDto menuItemDto = new MenuItemDto();

            // Get class name
            String classNameTxt = submenuItem.getAttribute("class");
            menuItemDto.setClassName(classNameTxt);
            // Find the <a> tag inside submenuItem
            WebElement linkElement = null;
            try {
                linkElement = submenuItem.findElement(By.className("link"));
            } catch (Exception e) {
                // No link found
            }

            if (linkElement != null) {
                text = linkElement.getAttribute("title").trim();
//                String text = linkElement.get.trim();
                String link = linkElement.getAttribute("href");
                menuItemDto.setContent(text);
                menuItemDto.setUrl(link);
            }

            // Determine if it is PARENT or CHILD
            if (classNameTxt.contains(classContentMain)) {
                menuItemDto.setObjType("PARENT");
                parContent = text;
            } else {
                menuItemDto.setObjType("CHILD");
                menuItemDto.setParContent(parContent);
            }
            // Print the object
            System.out.println(menuItemDto);
        }
//        driver.quit();
        driver.close();
    }
}