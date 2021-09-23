import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        char cha = ' ';
        key = key - 65;
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch<= 'z')){
            if ((ch + key > 'z') || (ch + key) > 'Z' && ch + key < 'a'){
                cha = (char) (ch + key - 26);
            }else {
                cha = (char) (ch + key);
            }
        }else{
            return ch;
        }
        return cha;
    }

    public static char decryptCaesarLetter(char ch, int key) {
        char cha = ' ';
        key = key - 65;
        if ((ch >= 'A' && ch <= 'Z') || ch >= 'a' && ch <= 'z'){
            if (ch - key < 'A' || ch >= 'a' && ch < 'a' + key){
                cha = (char) (ch - key + 26);
            }else {
                cha = (char) (ch - key);
            }
        }else{
            return ch;
        }
        return cha;
    }

    public static String encryptVigenere(String message, String key) {
        String output = "";
        int count = 0;

        for (int i = 0; i < message.length(); i++){
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') || (message.charAt(i) >= 'a' && message.charAt(i) <= 'z')) {
                output += (encryptCaesarLetter(message.charAt(i), key.charAt(count)));
                if (count < key.length()-1){
                    count++;
                }else{
                    count = 0;
                }

            } else {
                output += message.charAt(i);
            }
        }
        return output;
    }

    public static String decryptVigenere(String message, String key) {
        String output = "";
        int count = 0;

        for (int i = 0; i < message.length(); i++){
            if ((message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') || (message.charAt(i) >= 'a' && message.charAt(i) <= 'z')) {
                output += (decryptCaesarLetter(message.charAt(i), key.charAt(count)));
                if (count < key.length()-1){
                    count++;
                }else{
                    count = 0;
                }

            } else {
                output += message.charAt(i);
            }
        }
        return output;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
