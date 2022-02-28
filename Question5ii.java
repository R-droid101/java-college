import java.util.*;

public class Question5ii {

    static int isVowel(char ch) { // utility function to check if the given character is a vowel
        char vowels[] = { 'a', 'e', 'i', 'o', 'u' };
        for (char vowel : vowels)
            if (vowel == ch)
                return 1; // returns 1 if the character is a vowel
        return 0; // returns 0 if the character is not a vowel
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        String words[] = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
            words[i] = words[i].toLowerCase(); // storing the words in lower case for easy comparison
        }
        for (int i = 0; i < n; i++) {
            char chars[] = words[i].toCharArray(); // converting the word to character array
            for (int j = 0; j < chars.length; j++)
                chars[j] = (isVowel(chars[j]) == 1) ? 'V' : 'C'; // converting the given code to vowels or consonants
            words[i] = String.valueOf(chars);
            words[i] = words[i].replaceAll("[C]+", "C"); // removing the consecutive C's using regex
            words[i] = words[i].replaceAll("[V]+", "V"); // removing the consecutive V's using regex
        }
        System.out.println();
        // printing the sequence and number of "VC"s in each word
        for (String word : words) {
            int c = 0;
            System.out.println(word);
            char chars[] = word.toCharArray();
            for (int j = 0; j < chars.length - 1; j++)
                if (chars[j] == 'V' && chars[j + 1] == 'C')
                    c++;
            System.out.println(c);
        }
        sc.close();
    }
}
