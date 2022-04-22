import java.util.*;

class Encoding {
    // instance variables of class encoding according to the question
    String inputtext; // text to input
    public static String[] SA; // string array
    public static int[] IA; // index array
    public static int maxLength = 0; // to store max length of string

    Encoding(String str) { // constructor to split inputtext into words and store them in SA
        inputtext = str;
        String input[] = inputtext.split(" ");
        if (input.length > maxLength) // changes the max length of the array as and when it is updated
            maxLength = input.length;

        if (SA == null)
            SA = input.clone();
        else {
            String temp[] = new String[SA.length + input.length];
            for (int i = 0; i < SA.length; i++)
                temp[i] = SA[i];
            for (int i = 0; i < input.length; i++)
                temp[i + SA.length] = input[i];
            SA = temp.clone();
        }
    }

    static void sort() { // sorting the list of words lexicographically
        // using bubble sort
        for (int i = 0; i < SA.length - 1; i++) {
            String temp; // temporary string for bubble sort
            for (int j = i + 1; j > 0; j--) {
                if (SA[j].compareTo(SA[j - 1]) < 0) {
                    temp = SA[j];
                    SA[j] = SA[j - 1];
                    SA[j - 1] = temp;
                }
            }
        }
        String tempArr[] = new String[SA.length]; // array to help remove the duplicates
        int c = 1;
        // removing the duplicates
        tempArr[0] = SA[0];
        for (int i = 1; i < SA.length; i++) {
            if (SA[i].equals(SA[i - 1]))
                continue;
            else
                tempArr[c++] = SA[i];
        }
        SA = tempArr.clone(); // copying the tempArr array to SA
    }

    void encodeText() { // to encode the individual words to each text based on the index of word in sorted list
        String temp[] = inputtext.split(" "), word;
        int index = -1;
        IA = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            word = temp[i];
            for (int j = 0; j < SA.length; j++) {
                if (word.equals(SA[j])) {
                    index = j; // finding index of the word in sorted list
                    break;
                }
            }
            IA[i] = index;
        }

        // printing the encoded text
        System.out.print("[");
        for (int i = 0; i < IA.length; i++) {
            System.out.print(IA[i]);
            if (i != IA.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    void encodeText(boolean equal) { // overloaded method
        if (!equal) { // calling the previous encodeText method in case that is required
            this.encodeText();
            return;
        }

        String temp[] = inputtext.split(" ");
        String word;
        int index = -1, diff;
        IA = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            word = temp[i];
            for (int j = 0; j < SA.length; j++) {
                if (word.equals(SA[j])) {
                    index = j;
                    break;
                }
            }
            IA[i] = index;
        }

        System.out.print("[");
        for (int i = 0; i < IA.length; i++) {
            System.out.print(IA[i]);
            if (i != IA.length - 1) 
                System.out.print(", ");
        }
        diff = maxLength - IA.length;
        if (diff != 0)
            System.out.print(", ");
        for (int i = 0; i < diff; i++) {
            System.out.print("-1");
            if (i != diff - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class Question7 { // main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sc.nextLine();
        Encoding enc[] = new Encoding[n]; // creating n objects of Encoding class
        // inputting the text
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();
            enc[i] = new Encoding(temp);
        }
        Encoding.sort();
        // printing sorted list
        System.out.println("\nSorted list of words:");
        for (int i = 0; i < Encoding.SA.length; i++)
            if (Encoding.SA[i] != null)
                System.out.print(Encoding.SA[i] + " ");
        // printing encoded list
        System.out.println("\nEncoded list from the first encodeText(): ");
        for (int i = 0; i < n; i++)
            enc[i].encodeText();
        // printing encoded list by using the overloaded encodeText() method
        System.out.println("Encoded list from the second encodeText(): ");
        for (int i = 0; i < n; i++) 
            enc[i].encodeText(true);
        sc.close();
    }
}