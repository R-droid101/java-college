import java.io.*;
import java.util.*;

public class Question16 {
    public static void main(String args[]) throws FileNotFoundException {
        String str, sent, spch, sentParse[], spchParse[];
        int pos;

        Map<String, ArrayList<String>> map = new TreeMap<>();
        ArrayList<String> aux = new ArrayList<>();
        ArrayList<String> n = new ArrayList<>();
        ArrayList<String> v = new ArrayList<>();
        ArrayList<String> adj = new ArrayList<>();
        ArrayList<String> det = new ArrayList<>();

        File file = new File("./input.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            pos = str.indexOf("(");
            sent = str.substring(0, pos).trim();
            spch = str.substring(pos + 1, str.length() - 1);
            spchParse = spch.split(" ");
            sentParse = sent.split(" ");
            for (int i = 0; i < sentParse.length; i++)
                sentParse[i] = sentParse[i].replaceAll("[^a-zA-Z]", "");
            for (int i = 0; i < spchParse.length; i++) {
                if (spchParse[i].equals("AUX"))
                    aux.add(sentParse[i]);
                else if (spchParse[i].equals("N"))
                    n.add(sentParse[i]);
                else if (spchParse[i].equals("V"))
                    v.add(sentParse[i]);
                else if (spchParse[i].equals("ADJ"))
                    adj.add(sentParse[i]);
                else if (spchParse[i].equals("DET"))
                    det.add(sentParse[i]);
            }
        }

        TreeSet<String> saux = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        aux.removeIf(s -> !saux.add(s));
        TreeSet<String> sn = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        n.removeIf(s -> !sn.add(s));
        TreeSet<String> sv = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        v.removeIf(s -> !sv.add(s));
        TreeSet<String> sadj = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        adj.removeIf(s -> !sadj.add(s));
        TreeSet<String> sdet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        det.removeIf(s -> !sdet.add(s));
        map.put("AUX", aux);
        map.put("N", n);
        map.put("V", v);
        map.put("ADJ", adj);
        map.put("DET", det);

        System.out.println(map);

        System.out.print("\nEnter your input phrase: ");
        Scanner sc1 = new Scanner(System.in);
        String input = sc1.nextLine(), inputParse[] = input.split(" "), tempInput;
        String ragged[][] = new String[inputParse.length][];
        int c;
        for (int i = 0; i < inputParse.length; i++) {
            c = 0;
            tempInput = inputParse[i].substring(0, 1).toUpperCase() + inputParse[i].substring(1);
            for (String s : map.keySet()) {
                if (map.get(s).contains(inputParse[i]) || map.get(s).contains(tempInput))
                    c++;
            }
            ragged[i] = new String[c];
        }
        for (int i = 0; i < inputParse.length; i++) {
            c = 0;
            tempInput = inputParse[i].substring(0, 1).toUpperCase() + inputParse[i].substring(1);
            for (String s : map.keySet()) {
                if (map.get(s).contains(inputParse[i]) || map.get(s).contains(tempInput))
                    ragged[i][c++] = s;
            }
        }
        for (int i = 0; i < ragged.length; i++) {
            for (int j = 0; j < ragged[i].length; j++)
                System.out.print(ragged[i][j] + " ");
            System.out.println();
        }

        System.out.print("\nEnter your tag sequence: ");
        String tag = sc1.nextLine(), tagParse[] = tag.split(" ");
        boolean flag = true;
        sc1.close();
        outer: for (int i = 0; i < tagParse.length; i++) {
            for (int j = 0; j < ragged[i].length; j++) {
                if (tagParse[i].equals(ragged[i][j]))
                    break;
                if (j == ragged[i].length - 1) {
                    flag = false;
                    break outer;
                }
            }
        }
        if (flag)
            System.out.println("Accepted");
        else
            System.out.println("Not Accepted");
    }
}
