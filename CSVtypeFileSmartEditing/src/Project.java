import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Project {
    private ArrayList<String[]> arrayList = new ArrayList<String[]>();

    public Project(ArrayList<String[]> array) throws IOException {
        arrayList = array;//this is an arrayList from the previous class
        for (int i = 1; i < arrayList.size(); i++) {//this part of the code prints an arrayList and counts the each sum of  criteria in each row
            System.out.println();
            int sum = 0;
            String[] row = arrayList.get(i);//creating the string array which contains row elements of arrayList
            for (int m = 2; m < row.length - 1; m++) {
                int in = Integer.parseInt(row[m]);//turning string elements into integers
                sum = sum + in;//counting summary

            }
            String st = String.valueOf(sum);//when the sum is counted it turns into string so we could put it into arraylist
            row[row.length - 1] = st;//the last element of row will be the summary of previous criteria
            for (int j = 0; j < arrayList.get(i).length; j++) {
                System.out.print(arrayList.get(i)[j] + " ");//printing an arrayList
            }

        }
        System.out.println();
        boolean bol = true;
        do {
            System.out.println();
            System.out.println("1.Enter project marks.\n2.Add new project.\n3.Delete project.\n4.Save and Exit.\n5.Exit without saving.");//this is the menu with options
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            switch (input) {
                case "1":
                    System.out.println("1.Enter project marks.");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("choose the id");
                    String idSearch = scanner.nextLine();
                    for (int k = 0; k < arrayList.size(); k++) {
                        System.out.println();
                        if (idSearch.equals(arrayList.get(k)[0])) {
                            for (int y = 2; y < arrayList.get(k).length; y++) {
                                System.out.println("Enter new number for this id");
                                String num = scanner.nextLine();
                                arrayList.get(k)[y] = num; //user changing all numbers of chosen id
                            }
                        }
                    }
                    for (int i = 1; i < arrayList.size(); i++) {//this part of the code prints an arrayList and counts the each sum of  criteria in each row
                        System.out.println();
                        int sum = 0;
                        String[] row = arrayList.get(i);//creating the string array which contains row elements of arrayList
                        for (int m = 2; m < row.length - 1; m++) {
                            int integer = Integer.parseInt(row[m]);//turning string elements into integers
                            sum = sum + integer;//counting summary
                        }
                        String st = String.valueOf(sum);//when the sum is counted it turns into string so we could put it into arraylist
                        row[row.length - 1] = st;//the last element of row will be the summary of previous criteria
                        for (int j = 0; j < arrayList.get(i).length; j++) {
                            System.out.print(arrayList.get(i)[j] + " ");//printing an arrayList
                        }

                    }

                    break;
                case "2":
                    System.out.println("2.Add new project.");
                    ArrayList<String> ar = new ArrayList<String>();//creating new arrayList where  user will put all elements of new row
                    for (int i = 0; i < arrayList.get(0)[i].length(); i++) {
                        Scanner three = new Scanner(System.in);
                        System.out.println("Enter an element of row");
                        String inputTwo = three.nextLine();
                        ar.add(inputTwo);//put all elements of new row into an arrayList
                    }
                    String[] newLine = ar.toArray(new String[0]);//creating the string array and put all arrayList elements into it
                    Pattern p = Pattern.compile("^[PF]\\d{6,7}$");
                    Matcher m = p.matcher( newLine[0]);
                    Scanner four = new Scanner(System.in);
                    for(int d=0;d<arrayList.size();d++){
                        while(m.find()||newLine.equals(arrayList.get(d)[0])){
                            String str = four.nextLine();
                            newLine[0] = str;
                        }
                    }

//                        if (!m.find()) {
//                            do {
//                                System.out.println("enter correct id");
//                                String str = four.nextLine();
//                                newLine[0] = str;
//                            } while (m.find());
//                        }
//                        for (int l = 0; l < arrayList.size(); l++) {
//                            if (newLine[0].equals(arrayList.get(l)[0])) {
//
//                                System.out.println("this id already exists");
//                                do {
//                                    String s = four.nextLine();
//                                    newLine[0] = s;
//                                } while (!newLine[0].equals(arrayList.get(l)[0]));
//                                l = 0;
//                            }
//                        }
                    arrayList.add(newLine);//adding new row to main arrayList
                    for (int i = 1; i < arrayList.size(); i++) {//this part of the code prints an arrayList and counts the each sum of  criteria in each row
                        System.out.println();
                        int sum = 0;
                        String[] row = arrayList.get(i);//creating the string array which contains row elements of arrayList
                        for (int g = 2; g < row.length - 1; g++) {
                            int integer = Integer.parseInt(row[g]);//turning string elements into integers
                            sum = sum + integer;//counting summary

                        }
                        String st = String.valueOf(sum);//when the sum is counted it turns into string so we could put it into arraylist
                        row[row.length - 1] = st;//the last element of row will be the summary of previous criteria
                        for (int j = 0; j < arrayList.get(i).length; j++) {
                            System.out.print(arrayList.get(i)[j] + " ");//printing an arrayList
                        }

                    }
                    break;
                case "3":// if the user chooses 3 , the user will have to write a Student name id which he/she wants to delete.
                    System.out.println("Choose Student id ");
                    Scanner inTWo = new Scanner(System.in);
                    String inp = inTWo.nextLine();
                    inp.trim();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (inp.equals(arrayList.get(i)[0])) {//if the program will find this Id in arrayList, it will delete the whole row which contains it.
                            arrayList.remove(i); //it cannot remove the last row. The other rows can be deleted without any problem
                        }
                        System.out.println();
                        for (int j = 0; j < arrayList.get(i).length; j++) {
                            System.out.print(arrayList.get(i)[j] + " ");
                        }
                    }
                    break;
                case "4":// if the user chooses 4 the program will rewrite the file and the menu will not appear anymore and the program will end
                    System.out.println("4.Save and Exit.");
                    File myFoo = new File("shkila.csv");
                    FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
                    // false to overwrite.
                    for (int i = 0; i < arrayList.size(); i++) {
                        fooWriter.append("\n");
                        for (int j = 0; j < arrayList.get(i).length; j++) {
                            fooWriter.write(arrayList.get(i)[j]);
                        }
                    }
                    fooWriter.close();
                    bol = false;
                    break;
                case "5"://if the user chooses 5, the menu will not appear anymore and the program will end
                    System.out.println("5.Exit without saving.");
                    bol = false;
                    break;
            }

        } while (bol);
    }

}
