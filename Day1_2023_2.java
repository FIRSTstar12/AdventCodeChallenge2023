// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.io.*;
class Day1_2023_2 {
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] numArray = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
        };

        int sum = 0;
        int a=0,b=0;
        while (true) {
            String x = "";
            try {
                x = input.readLine();
            } catch (Exception e) {
                ;
            }
            if (x.equals("")) break;

            first:
            for (int i=0; i<x.length(); i++) {
                if (Character.isDigit(x.charAt(i))) {
                    a= x.charAt(i) - '0';
                    break;
                }

                for (int j=0; j<numArray.length; j++) {
                    if (numArray[j].length() +i < x.length()) {
                        String sub = x.substring(i, i+numArray[j].length());
                        if (numArray[j].equals(sub)) {
                            a = j;
                            break first;
                        }
                    }
                }
            }

            second:
            for (int i=x.length()-1; i>=0; i--) {
                if (Character.isDigit(x.charAt(i))) {
                    b= x.charAt(i) - '0';
                    break;
                }

                for (int j=0; j<numArray.length; j++) {
                    if (i-numArray[j].length()+1 >= 0) {
                        String sub = x.substring(i-numArray[j].length()+1, i+1);
                        if (numArray[j].equals(sub)) {
                            b = j;
                            break second;
                        }
                    }
                }
            }
            sum += a*10+b;
        }
        System.out.println(sum);
    }
}