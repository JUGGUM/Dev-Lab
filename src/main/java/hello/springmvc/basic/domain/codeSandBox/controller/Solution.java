package hello.springmvc.basic.domain.codeSandBox.controller;

import java.io.*;
import java.util.*;
import lombok.extern.slf4j.Slf4j;

class Result {

    /*
     * Complete the 'simpleArraySum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY ar as parameter.
     */

    public static int simpleArraySum(List<Integer> ar) {
        // Write your code here
        return 3;
    }

}
@Slf4j
public class Solution {

    public static void main(String[] args) {
            String s = "12:45:54PM";
            // 12:45:54PM -> 12:45:54
            int hour = Integer.parseInt(s.substring(0, 2)); // 12
            String period = s.substring(8, 10); // AM or PM
            String hourString;

            if (period.equals("PM")) {
                if (hour != 12) {
                    hour += 12; // Convert PM hour to 24-hour format
                }
                // If hour is 12 PM, it stays as 12
                hourString = String.format("%02d", hour); // Ensure 2-digit format
            } else {
                if (hour == 12) {
                    hourString = "00"; // Midnight case (12 AM is 00:xx)
                } else {
                    hourString = String.format("%02d", hour); // Ensure 2-digit format
                }
            }

            // Get minutes and seconds part
            String clockFormat24 = s.substring(2, 8);
            log.error(hourString.concat(clockFormat24));
    }
}
