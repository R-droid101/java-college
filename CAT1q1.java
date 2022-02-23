import java.util.*;

class CAT1q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input string:");
        String str = sc.nextLine();
        str = str.toLowerCase();
        str = str.replaceAll(" ", "");
        String encrypt = "";
        int i = 0;
        while (i < str.length()) {
            if (i + 2 < str.length()) {
                encrypt += str.charAt(i + 1);
                encrypt += str.charAt(i + 2);
                encrypt += str.charAt(i);
                encrypt += " ";
            }
            i += 3;
        }
        if (str.length() == i - 2)
            encrypt += str.charAt(i - 3);
        else {
            encrypt += str.charAt(i - 2);
            encrypt += str.charAt(i - 3);
        }
        System.out.println("\n" + encrypt);
        sc.close();
    }
}