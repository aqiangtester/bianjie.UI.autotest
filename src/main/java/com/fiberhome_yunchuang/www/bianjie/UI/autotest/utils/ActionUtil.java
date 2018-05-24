package com.fiberhome_yunchuang.www.bianjie.UI.autotest.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionUtil {  
    
    private static Actions act;  
      
    public static void setAction(WebDriver driver){  
        act = new Actions(driver);  
    }  
      
      
    public static void DRAG_ELEMENT(WebElement e,int xOffset,int yOffset){  
        Action dragAllTheWayUp = act.moveToElement(e).clickAndHold().moveByOffset(xOffset, yOffset).release().build();  
        dragAllTheWayUp.perform();  
    }  
} 
