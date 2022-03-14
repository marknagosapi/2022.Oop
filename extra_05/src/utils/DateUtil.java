package utils;

public class DateUtil {

    //Methods
     public boolean leapYear(int year){
         if(year%4==0){
             if(year%100!=0){
                 return true;
             } else{
                 return year % 400 == 0;
             }
         } else {
             return false;
         }
     }

     public boolean isValidDate(int year,int month, int day){
         if(year < 1 || year > 2022){
             return false;
         }

         if(month < 1 || month > 12){
             return false;
         }

         if(month%2==0){
             if(month==8 || month == 10 || month == 12){
                 if (day < 1 || day > 31) {
                     return false;
                 }
             } else {
                 if (month == 2) {
                     if (leapYear(year)) {
                         if (day < 1 || day > 29) {
                             return false;
                         }
                     } else {
                         if (day < 1 || day > 28) {
                             return false;
                         }
                     }
                 } else {

                     if (day < 1 || day > 30) {
                         return false;
                     }
                 }
             }
         } else {
             if(day < 1 || day > 31){
                 return false;
             }
         }
         return true;
     }
}
