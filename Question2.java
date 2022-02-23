public class Question2 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i += 3) { // Looping through the arguments
            System.out.println(args[i]); // printing name
            int balance = 0;
            int totAmt = Integer.parseInt(args[i + 1]); // storing total amount
            int transAmt = Integer.parseInt(args[i + 2]); // storing transaction amount
            if (Math.abs(transAmt) > Math.min(totAmt, 25000)) { // checking if transaction is valid
                System.out.println("Failed Transaction");
                System.out.println(totAmt);
                continue;
            }
            // if transaction is valid
            if (transAmt < 0) { // checking if withdrawal
                balance = totAmt - Math.abs(transAmt);
                // applying necessary charges
                if (Math.abs(transAmt) <= 500)
                    balance -= 5;
                else if (Math.abs(transAmt) <= 1000)
                    balance -= 8;
                else if (Math.abs(transAmt) <= 5000)
                    balance -= 10;
                else if (Math.abs(transAmt) <= 15000)
                    balance -= 12;
                else if (Math.abs(transAmt) <= 25000)
                    balance -= 15;
            } else // checking if deposit
                balance = totAmt + transAmt;
            System.out.println(balance);
        }
    }
}