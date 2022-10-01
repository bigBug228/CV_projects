import java.util.Scanner;

public class Strings {
    public Strings() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String anword = sc.nextLine();
        char[] chArr1 = word.toLowerCase().toCharArray();
        char[] chArr2 = anword.toLowerCase().toCharArray();

        int i;
        int j;
        char tmp;
        for(i = chArr1.length - 1; i > 0; --i) {
            for(j = 0; j < i; ++j) {
                if (chArr1[j] > chArr1[j + 1]) {
                    tmp = chArr1[j];
                    chArr1[j] = chArr1[j + 1];
                    chArr1[j + 1] = tmp;
                }
            }
        }

        for(i = chArr2.length - 1; i > 0; --i) {
            for(j = 0; j < i; ++j) {
                if (chArr2[j] > chArr2[j + 1]) {
                    tmp = chArr2[j];
                    chArr2[j] = chArr2[j + 1];
                    chArr2[j + 1] = tmp;
                }
            }
        }

        String valueOfchar1 = String.valueOf(chArr1);
        String valueOfchar2 = String.valueOf(chArr2);
        valueOfchar1 = valueOfchar1.replaceAll(" ", "");
        valueOfchar2 = valueOfchar2.replaceAll(" ", "");
        System.out.println(valueOfchar1);
        System.out.println(valueOfchar2);
        System.out.println(valueOfchar1.equalsIgnoreCase(valueOfchar2));
    }
}
