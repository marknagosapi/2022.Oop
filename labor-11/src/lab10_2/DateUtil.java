package lab10_2;

public class DateUtil {

    public static boolean leapYear(int ev) {
        if (ev % 4 == 0) {
            if (ev % 100 == 0) {
                return ev % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidDate(int ev,int ho,int nap){
        if(ev < 1 || ev > 2022){
            return false;
        }

        if(ho < 1 || ho > 12){
            return false;
        }

        if(ho==2){
            if(leapYear(ev)){
                if(nap < 1 || nap > 29){
                    return true;
                }
            } else {
                if(nap < 1 || nap > 28){
                    return true;
                }
            }
        } else {
            if (nap < 1 || nap > 31) {
                return false;
            }
        }
        return true;
    }
}
