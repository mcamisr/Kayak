package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.GetCurrentDriver.*;

public class KayakHomePage {

    public static WebElement closeItemOrigin(){
        return driver().findElement(By
                .xpath("(//div[@role='listitem']//div[contains(@class,'close')]//div[@role='button'])[1]"));
    }

    public static WebElement originCity(){
        return driver().findElement(By.xpath("//input[@placeholder='Origen']"));
    }

    public static WebElement optionCity(String city){
        return driver().findElement(By.xpath("//li[contains(@aria-label,'"+ city +"')]"));
    }

    public static WebElement destinationCity(){
        return driver().findElement(By.xpath("(//div[contains(@aria-label,'Destino')])[1]"));
    }

    public static WebElement destinyCity(){
        return driver().findElement(By.xpath("//div[@role='textbox']//input[@placeholder='Destino']"));
    }

    public static WebElement reservationPerson(){
        return driver().findElement(By.xpath("//div[@class='PLU8']//div"));
    }

    public static WebElement selectMorePassengers(String passenger){
        return driver().findElement(By
                .xpath("(//label//span[contains(text(),'"+ passenger.trim() +"')]//following::button)[2]"));
    }

    public static WebElement selectDate(){
        return driver().findElement(By
                .xpath("(//div[@aria-label='Fechas de salida y llegada']//div[@role='button']//div)[1]"));
    }

    public static WebElement selectDayFlight(String month, String day){
        return driver().findElement(By
                .xpath("//div[@data-month='"+ month +"']//div[contains(@class,'days')]//div[contains(text(),'"+ day +"')]"));
    }

    public static WebElement searchFlight(){
        return driver().findElement(By
                .xpath("//button[@aria-label='Buscar']"));
    }

    public static WebElement nextMonth(){
        return driver().findElement(By
                .xpath("//div[@aria-label='Mes siguiente' or @aria-label='Next month']"));
    }

    public static WebElement closePopUp(){
        return driver().findElement(By
                .xpath("//a[@aria-label='Cerrar']"));
    }

    public static WebElement updateDate(){
        return driver().findElement(By
                .xpath("//div[@aria-label='Formulario de búsqueda']//div[@aria-label='Fechas de salida y llegada']"));
    }


}
