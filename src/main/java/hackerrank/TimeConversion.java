//Given a time in -hour AM/PM format, convert it to military (24-hour) time.
//
//        Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
//        - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
//
//        Example
//
//
//        Return '12:01:00'.
//
//
//        Return '00:01:00'.
//
//        Function Description
//
//        Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
//
//        timeConversion has the following parameter(s):
//
//        string s: a time in  hour format
//        Returns
//
//        string: the time in  hour format
//        Input Format
//
//        A single string  that represents a time in -hour clock format (i.e.:  or ).
//
//        Constraints
//
//        All input times are valid
//        Sample Input
//
//        07:05:45PM
//        Sample Output
//
//        19:05:45

package hackerrank;

public class TimeConversion {

    private static void timeConversion(String s) {
        String[] listTime = s.split(":");
        String hour = listTime[0];
        String minutes = listTime[1];
        String secounds = listTime[2].substring(0, 2);
        String caser = listTime[2].substring(2, 4);
        if (caser.equals("AM")) {
            if (hour.equals("12"))
                hour = "00";

            System.out.println(hour + ":" + minutes + ":" + secounds);
        } else {
            if (!hour.equals("12")) {
                int h = Integer.parseInt(hour);
                h = h + 12;
                hour = "" + h;
            }
            System.out.println(hour + ":" + minutes + ":" + secounds);
        }
    }

    public static void main(String[] args) {

    }
}
