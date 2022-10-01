import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        ArrayList<String[]> mainArr = new ArrayList<String[]>();//creating empty arrayList
        System.out.println("Enter the file name");
        String file = in.nextLine();
        mainArr = arrayList(file);//filling mainArrayList with elements of file which name user already entered
        int sum = 0;
        String[] firstRow = mainArr.get(0);//creating a string array which contains the first row of arrayList
        ArrayList<Integer> oneHundred = firstLine(firstRow);//creating an integer arrayList which contains all numbers from the first row of mainArr
        for (int j = 0; j < oneHundred.size(); j++) {
            sum = sum + oneHundred.get(j);//this is the sum of all elements of integer arrayList
        }
        if (sum != 100) {//if the sum is not 100, the user will rewrite the first row of main arrayList
            do {
                System.out.println("The summary of all criteria of first row is not equal to 100,\nplease enter all criteria of first row by yourself");
                for (int i = 2; i < mainArr.get(0).length - 1; i++) {
                    Scanner two = new Scanner(System.in);
                    System.out.println("Enter an element");
                    String input = two.nextLine();
                    input = input.trim();
                    mainArr.get(0)[i] = input;
                }
                String[] firR = mainArr.get(0);//creating a string array which contains the first row of arrayLIst
                ArrayList<Integer> oneHund = firstLine(firR);//creating an integer arrayList which contains all numbers from the first row of mainArr
                sum = 0;
                for (int j = 0; j < oneHund.size(); j++) {
                    sum = sum + oneHund.get(j);//this is the sum of all elements of integer arrayList
                }
            } while (sum != 100);
        }
        for (int i = 0; i < mainArr.get(0).length; i++) {
            System.out.print(mainArr.get(0)[i]);//printing the first row of mainArr in console
        }
        Project project = new Project(mainArr);
    }

    public static ArrayList<String[]> arrayList(String fileTwo) {//in this method program creates an arrayList from all elements of file.
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        try {
            File file = new File(fileTwo); //working with file which user has entered.
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {//reading all file
                String line = scanner.nextLine();
                String[] numSt = line.split(",");//making the string array from row elements.
                for (int i = 2; i < numSt.length; i++) {
                    numSt[i].trim();//trimming criteria elements
                }
                arrayList.add(numSt);//filling the main arrayList with file elements.

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            System.exit(1);
        }
        return arrayList;
    }

    public static ArrayList<Integer> firstLine(String[] criterias) { //This method creates an integer arrayList which contains all numbers from the first row of file.
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 2; i < criterias.length - 1; i++) {//checking all criteria from the first row of main arrayList
            Pattern p = Pattern.compile("\\(\\d+\\)");
            Matcher m = p.matcher(criterias[i]);
            while (m.find()) {//searching for round brackets and what is inside them
                String el = m.group();
                Pattern pa = Pattern.compile("\\d+");
                Matcher ma = pa.matcher(el);
                while (ma.find()) {//searching for what is inside the round brackets
                    String ele = ma.group();//now we have a string element which contains only numbers
                    int number = Integer.parseInt(ele);//turn previous element into integer
                    intArrayList.add(number);//adding this element to the integer array


                }
            }

        }
        return intArrayList;
    }

}