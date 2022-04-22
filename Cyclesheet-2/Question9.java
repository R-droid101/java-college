import java.util.*;

// interface as per question
interface Inter {
    public static String arr[] = { "0101", "0100", "0000", "1111", "1000", "1011", "1001", "0111", "1010", "0110" };

    // nested class
    class Nest {
        public String arr1[][] = new String[10][2];

        public String decimalEq(String n) {
            int s = 0;
            s += Character.getNumericValue(n.charAt(3)) * -1;
            s += Character.getNumericValue(n.charAt(2)) * -2;
            s += Character.getNumericValue(n.charAt(1)) * 4;
            s += Character.getNumericValue(n.charAt(0)) * 8;
            return Integer.toString(s);
        }

        Nest() {
            for (int i = 0; i < 10; i++) {
                arr1[i][0] = arr[i];
                arr1[i][1] = decimalEq(arr[i]);
            }
        }
    }
}

class Class8421 extends Inter.Nest { // inherits the nested class inside interface
    int n;

    Class8421(int x) {
        super();
        n = x;
    }

    String convert() {
        int n1 = n, d;
        String x = "";
        while (n1 > 0) {
            d = n1 % 10;
            for (int i = 0; i < 10; i++) {
                if (Integer.parseInt(arr1[i][1]) == d) {
                    x = arr1[i][0] + " " + x;
                    break;
                }
            }
            n1 /= 10;
        }
        return x;
    }
}

class Complement9 extends Class8421 { // inherits class as per question
    int n, comp;
    String code;

    Complement9(int x) {
        super(x);
        n = x;
        comp = 0;
        code = "";
    }

    void findComplement() {
        String str = convert();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '1')
                code += '0';
            else if (ch == '0')
                code += '1';
            else
                code += ch;
        }
    }

    void findComplementDec() {
        String w = "";
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            if (ch != ' ')
                w += ch;
            else {
                for (int j = 0; j < 10; j++) {
                    if (arr1[j][0].equals(w)) {
                        comp = comp * 10 + Integer.parseInt(arr1[j][1]);
                        break;
                    }
                }
                w = "";
            }
        }
    }
}

class Question9 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        Complement9 c1 = new Complement9(n);
        c1.findComplement();
        c1.findComplementDec();
        System.out.println("\n84-2-1 code: " + c1.convert());
        System.out.println("Complementary code: " + c1.code);
        System.out.println("Decimal Complement: " + c1.comp);
        sc.close();
    }
}
