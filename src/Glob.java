import java.util.Scanner;

public class Glob {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

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
