import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create needed object
        Random random = new Random();

        //Get user input
        Scanner input = new Scanner(System.in);
        System.out.print("How many letters do you want in your password?: ");
        int stringPasswordLength = input.nextInt();
        System.out.print("How many numbers do you want in your password?: ");
        int intPasswordLength = input.nextInt();
        System.out.print("How many symbols do you want in your password?: ");
        int symbolPasswordLength = input.nextInt();

        //Combine needed things for password
        String finalPassword = createInts(intPasswordLength) + createString(stringPasswordLength) + createSymbols(symbolPasswordLength);

        //Print shuffled password
        System.out.println(shufflePassword(finalPassword, random));
    }


    //Generate random letters for password based on user's desired length
    public static String createString(int pwLength) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < pwLength; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }

    //Generate random ints for password based on user's desired length
    public static String createInts(int pwLength) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String letters = "123456789";

        for (int i = 0; i < pwLength; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }

    //Generate random symbols for password based on user's desired length
    public static String createSymbols(int pwLength) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String letters = "!@#$%&*";

        for (int i = 0; i < pwLength; i++) {
            sb.append(letters.charAt(random.nextInt(letters.length())));
        }
        return sb.toString();
    }

    // Shuffle the password using Fisher-Yates shuffle algorithm
    public static String shufflePassword(String finalPassword, Random random) {
        char[] passArray = finalPassword.toCharArray();

        for(int i = passArray.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = passArray[index];
            passArray[index] = passArray[i];
            passArray[i] = temp;
        }
        return new String(passArray);
    }

}




