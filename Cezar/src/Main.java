import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input");
        PrintWriter pw = new PrintWriter(file);
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.toLowerCase();
        char[] array = line.toCharArray();
        int shift = 4;
        ArrayList<Character> m = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            m.add((char) ('a' + i));
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = m.get((m.indexOf(array[i]) + shift) % m.size());
            pw.println(array[i]);
        }
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            array[i] = m.get((m.indexOf(array[i]) + (m.size() - shift))%m.size() );
            pw.println(array[i]);
        }
        System.out.println(array);
        pw.close();
    }
}
