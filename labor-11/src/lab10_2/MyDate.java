package lab10_2;


import static lab10_2.DateUtil.isValidDate;

public class MyDate implements Comparable<MyDate> {

    //Variables (Adattagok)
    private final int year;
    private final boolean valid;
    private final int day;
    private final int month;

    //Constructor
    public MyDate(int year, int month, int day) throws InvalidDateException {
        if(isValidDate(year,month,day)){
            throw new InvalidDateException("INVALID DATE");
        }
        this.valid = isValidDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean getValidity() {
        return valid;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        String result = Integer.toString(this.year);
        result += "/";
        if (this.month < 10) {
            result += "0" + Integer.toString(this.month);
        } else {
            result += Integer.toString(this.month);
        }
        result += "/";
        if (this.day < 10) {
            result += "0" + Integer.toString(this.day);
        } else {
            result += Integer.toString(this.day);
        }
        return result;
    }

    @Override
    public int compareTo(MyDate o) {
        if(this==o){
            return 0;
        }

       if(this.year == o.year){
           if(this.month == o.month){
               if(this.day == o.day){
                   return 0;
               } else {
                   return this.day - o.day;
               }
           } else {
               return this.month - o.month;
           }
       } else {
           return this.year - o.year;
       }
    }
}