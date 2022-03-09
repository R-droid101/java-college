import java.util.*;

public class Question6 {

    static char[] keysDict(char chars[], int len) {
        char keys[] = new char[len];
        int dictPosition = 0; // to navigate to the dictPositionition withing the dictionary
        for (int i = 0; i < chars.length; i++) {
            if (dictPosition == len) // if encountered all the keys, then break
                break;
            if (chars[i] == '\'' && chars[i + 2] == '\'') // checking for a key
                keys[dictPosition++] = chars[i + 1]; // if key found, appending to the keys array            
        }
        return keys;
    }

    static int[] sumArray(char chars[], int len) { // utility function to find the sum of the array
        int sums[] = new int[len];
        boolean isNegative; // to check if number is negative or not
        int dictPosition = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                int sum = 0;
                i++;
                outer: while (chars[i] != ')') {
                    isNegative = false;
                    if (chars[i] == '-') { // Checking if given number is negative or not
                        isNegative = true;
                        i++;
                    }
                    int num = 0; // temporary variable to extract and store the number
                    while (true) {
                        if (chars[i] == ',') { // adding the next number of the tuple
                            if (isNegative)
                                num = num * -1;
                            sum += num;
                            break;
                        } else if (chars[i] == ')') { // checking if we added the last element of the tuple
                            if (isNegative)
                                num = num * -1;
                            sum += num;
                            break outer;
                        } else { // converts the number from character to an integer
                            num *= 10; // if there is more than 1 digit in the number
                            num += Character.getNumericValue(chars[i]); // converting character to an integer
                        }
                        i++;
                    }
                    i++;
                }
                sums[dictPosition++] = sum;
                if (dictPosition == len)
                    break;
            }
        }
        return sums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter python dictionary: ");
        String dict = sc.nextLine(); // read the dictionary
        int len = 0; // variable to store the length of the dictionary
        char chars[] = dict.toCharArray(); // converting the dictionary to character array

        for (char character : chars) // finding the length of the dictionary
            if (character == ':')
                len++;

        char keys[] = new char[len]; // creating arrays to store keys and sum of values
        int sums[] = new int[len];

        keys = keysDict(chars, len); // extracting keys from the dictionary
        sums = sumArray(chars, len); // calculating the sum of values of tuples

        // printing the keys and sum of values
        System.out.print("\nArray 1 = [");
        for (int i = 0; i < len; i++) {
            System.out.print("\"" + keys[i] + "\"");
            if (i != len - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Array 2 = [");
        for (int i = 0; i < len; i++) {
            System.out.print(sums[i]);
            if (i != len - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        sc.close();
    }
}
