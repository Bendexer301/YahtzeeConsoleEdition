import java.util.Scanner;

/**
 * A class that contains various utility methods for input and output.
 */
public class Glob {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for input and returns the input as a string.
     * @param prompt
     * @return
     */
    public static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Prompts the user for input and returns the input as an integer.
     * @param prompt
     * @return
     */
    public static int inputInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Prompts the user for input and returns the input as a boolean.
     * @param prompt
     * @return
     */
    public static boolean inputBoolean(String prompt) {
        System.out.print(prompt + " (y/n) ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter 'y' or 'n'.");
            }
        }
    }

    /**
     * Prints a string with a specified width.
     * @param s
     * @param width
     * @param b
     */
    public static void printWithWidth(String s, int width, boolean b) {
        int sWidth = s.length();

        System.out.print(s);

        if (sWidth >= width) {
            if (b) System.out.println();
            return;
        }

        for (int i = 0; i < width-sWidth; i++) {
            System.out.print(" ");
        }
        if (b) System.out.println();
    }
}
