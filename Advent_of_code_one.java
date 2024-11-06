import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.*;

public class Advent_of_code_one {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "C:\\Users\\24mur\\Downloads\\Day1input.txt";
        File input = new File(filePath);
        Scanner scanner = new Scanner(input);
        int sum = 0;

        String[] numWords = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        HashMap<String,Integer> numsDiction = new HashMap<>();
        numsDiction.put("one",1);
        numsDiction.put("two",2);
        numsDiction.put("three",3);
        numsDiction.put("four",4);
        numsDiction.put("five",5);
        numsDiction.put("six",6);
        numsDiction.put("seven",7);
        numsDiction.put("eight",8);
        numsDiction.put("nine",9);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int length = line.length();

            String startWord = getFirstWord(line,numWords);
            String endWord = getLastWord(line,numWords);
            if (!Character.isDigit(startWord.charAt(0))) {
                System.out.println(startWord);
                startWord = Integer.toString(numsDiction.get(startWord));
            }
            if (!Character.isDigit(endWord.charAt(0))) {
                endWord = Integer.toString(numsDiction.get(endWord));
            }
//            var start = Integer.toString(startWord);
//            var last = Integer.toString(endWord);


            String num = startWord + endWord;
//            String wordNum = startWord + endWord;


            if (!num.equals("")){
                sum = sum + Integer.parseInt(num);
            }

        }
        System.out.println(sum);
    }

    public static String getFirstNum(String line) throws FileNotFoundException {
        String num = "";
        for (int i = 0; i < line.length(); i++) {
            char letter = line.charAt(i);
            if (Character.isDigit(letter)) {
                num = num + letter;
                break;
            }
        }
        return num;
    }

    public static String getLastNum(String line) throws FileNotFoundException {
        String num = "";
        for (int i = line.length() - 1; i >= 0; i--) {
            char letter2 = line.charAt(i);
            if (Character.isDigit(letter2)) {
                num = num + letter2;
                break;
            }
        }
        return num;
    }

    public static String getFirstWord(String line, String[] words) {
        String num = "";
        first:
        for (int i = 0; i <= line.length()-1; i++){
            char letter = line.charAt(i);
            if (Character.isDigit(letter)) {
                num = num + letter;
                break;
            }
            for (int x = 0;x <= words.length-1;x++){
                String y = words[x];
                if(i + y.length() >= line.length()){
                    continue;
                }
                String next = line.substring(i,i + y.length());
                if(y.equals(next)){
                    num = y;
                    break first;
                }
            }
        }
        return num;
    }

        public static String getLastWord (String line, String[] words) {
            String num = "";
            second:
            for (int i = line.length() - 1;i >= 0; i--) {
                char letter2 = line.charAt(i);
                if (Character.isDigit(letter2)) {
                    num = num + letter2;
                    break;
                }
                for (int x = 0; x <= words.length - 1; x++) {
                    String y = words[x];
                    if (i - y.length()+1 < 0) {
                        continue;
                    }
                    String next = line.substring(i - y.length() + 1,i+1);
                    if (y.equals(next)) {
                        num = y;
                        break second;
                    }
                }
            }
            return num;
        }
}

