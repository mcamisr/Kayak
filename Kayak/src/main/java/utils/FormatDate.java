package utils;


public class FormatDate {

    public static String monthAndYear(String date){
        String[] dateArray = date.split("/");
        return dateArray[2]+ "-"+ dateArray[1];
    }

    public static String monthAndYearUpdate(String date){
        String[] dateArray = date.split("/");
        return dateArray[2] + dateArray[1];
    }

    public static String day(String date){
        String[] dateArray = date.split("/");
        return dateArray[0];
    }
}
