import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String output = "";
        for (int i = 0; i < message.length(); i++){
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') || (message.charAt(i) >= 'a' && message.charAt(i) <= 'z')) {
                if ((message.charAt(i) + 3 > 'z') || (message.charAt(i) + 3) > 'Z' && message.charAt(i) + 3 < 'a'){
                    output += (char) (message.charAt(i) + 3 - 26);
                }else {
                    output += (char) (message.charAt(i) + 3);
                }
            }else {
                output += message.charAt(i);
            }
        }
        return output;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String output = "";
        for (int i = 0; i < message.length(); i++){
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') || (message.charAt(i) >= 'a' && message.charAt(i) <= 'z')) {
                if ((message.charAt(i) - 3 < 'A') || (message.charAt(i) - 3) < 'a' && message.charAt(i) - 3 > 'Z'){
                    output += (char) (message.charAt(i) - 3 + 26);
                }else {
                    output += (char) (message.charAt(i) - 3);
                }
            }else {
                output += message.charAt(i);
            }
        }
        return output;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String output = "";
        for (int i = 0; i < message.length(); i++){
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') || (message.charAt(i) >= 'a' && message.charAt(i) <= 'z')) {
                if ((message.charAt(i) + key > 'z') || (message.charAt(i) + key) > 'Z' && message.charAt(i) + key < 'a'){
                    int temp = message.charAt(i) + key;
                    while (temp - 26 > 'Z' || temp - 26 > 'z'){
                        temp = temp - 26;
                    }
                    output += (char) (temp - 26);
                }else {
                    output += (char) (message.charAt(i) + key);
                }
            }else {
                output += message.charAt(i);
            }
        }
        return output;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String output = "";
        for (int i = 0; i < message.length(); i++){
            key = key%26;
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') || (message.charAt(i) >= 'a' && message.charAt(i) <= 'z')) {
                if ((message.charAt(i) - key <= 'A') || (message.charAt(i) - key) <= 'a' && message.charAt(i) - key > 'Z'){
                    output += (char) (message.charAt(i) + 26 - key);
                }else {
                    output += (char) (message.charAt(i) - key);
                }
            }else {
                output += message.charAt(i);
            }
        }
        return output;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
