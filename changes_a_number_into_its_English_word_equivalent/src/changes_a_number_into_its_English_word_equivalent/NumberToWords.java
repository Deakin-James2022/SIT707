package changes_a_number_into_its_English_word_equivalent;
import java.util.Scanner;

public class NumberToWords {
    private static final String[] ONES = {
            "zero", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"
    };
    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty",
            "fifty", "sixty", "seventy", "eighty", "ninety"
    };
    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }
        return convertNumber(number).trim();
    }
    private static String convertNumber(int number) {
        if (number < 20) {
            return ONES[number];
        }
        if (number < 100) {
            return TENS[number / 10]
                    + (number % 10 != 0 ? " " + ONES[number % 10] : "");
        }
        if (number < 1000) {
            return ONES[number / 100] + " hundred"
                    + (number % 100 != 0 ? " and " + convertNumber(number % 100) : "");
        }
        if (number < 1_000_000) {
            return convertNumber(number / 1000) + " thousand"
                    + (number % 1000 != 0 ? " " + convertNumber(number % 1000) : "");
        }
        if (number < 1_000_000_000) {
            return convertNumber(number / 1_000_000) + " million"
                    + (number % 1_000_000 != 0 ? " " + convertNumber(number % 1_000_000) : "");
        }
        return "Number out of range";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println(convert(number));
        scanner.close();
    }
}
