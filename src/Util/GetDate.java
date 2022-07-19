package Util;

import java.sql.Date;

public class GetDate {
    public static Date getCurrentDate(){
        Date date = new Date(System.currentTimeMillis());
        return date;
    }

    public static void main(String[] args) {
        System.out.println(GetDate.getCurrentDate());
    }
}
