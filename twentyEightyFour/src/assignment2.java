// TWENTY EIGHTY FOUR GAME
import java.util.Scanner;
import java.util.Random;
public class assignment2 {
    public static int score = 0;
    public static void main(String[] args) {
        boolean win = false;
        int numOfCells = netGeneration();
        int [][] net = new int[numOfCells][numOfCells];
        Scanner in = new Scanner(System.in);
        int totalScore = 0;
        net = numGen(net);
        net = numGen(net);
        //in this cycle I created net buttons so the user could interact with the net.
        do {
            netDrawing(net);
            System.out.println("TotalScore " +  score );
            System.out.println("1.UP");
            System.out.println("2.DOWN");
            System.out.println("3.LEFT");
            System.out.println("4.RIGHT");
            int [][] copyNet = new int[net.length][];
            for(int i = 0; i < net.length; i++)
                copyNet[i] = net[i].clone();
            int move = in.nextInt();
            switch (move) {
                case 1 :
                    up(net);
                    break;
                case 2 :
                    down(net);
                    break;
                case 3 :
                    left(net);
                    break;
                case 4 :
                    right(net);
                    break;

            }
            boolean check = false;
            for(int i = 0; i < net.length; i++) {
                for(int j = 0; j < net.length; j++) {
                    if (copyNet[i][j] != net[i][j]) {
                        check = true;
                        break;
                    }
                }
            }
            if (check) net = numGen(net);
            else System.out.println("No changes, try again");
            if (!win && YouWin(net)) {
                win = true;
                System.out.println("You Win");

            }
        }while(gameOver(net));

        System.out.println("End Game");
    }

    public static int[][] numGen(int[][] net){// In this method program generates random numbers inside the net
        int numOfCells = net.length;

        Random random = new Random();
        int randRow = 0;
        int randColumn = 0;
        do {
            randRow =random.nextInt(numOfCells) ;
            randColumn = random.nextInt(numOfCells);

        } while (net[randRow][randColumn] != 0);

        net[randRow][randColumn] = 1;
        return net;
    }

    public static int netGeneration() {// In this method the user chooses the size of the net
        Scanner in = new Scanner(System.in);
        int numOfCells = 0;
        do {
            System.out.print("Enter the number of cells");
            numOfCells = in.nextInt();
        }while ( numOfCells > 10 ||  numOfCells < 4);
        return numOfCells;
    }


    public static void netDrawing(int [][] net) {//In this method the program makes the correct design of the net
        int numOfCells = net.length;
        String [][] strNet = new String[numOfCells][numOfCells];
        for (int l = 0 ; l < numOfCells ; l++ ) {
            for (int k = 0 ; k < numOfCells ; k++ ) {
                if ( net[l][k] <=10) strNet[l][k] = "000"+net[l][k];
                else if (net[l][k] <=100) strNet[l][k] = "00"+net[l][k];
                else if (net[l][k] <=1000) strNet[l][k] = "0"+net[l][k];
                else   strNet[l][k] = "" + net[l][k];
            }
        }

        for (int i = 0 ; i <  numOfCells ; i++) {
            for (int j = 0 ; j <  numOfCells ; j++) {
                System.out.print("------");
            }
            System.out.println("" );
            for (int j = 0 ; j <  numOfCells ; j++) {
                System.out.print("|"+ strNet[i][j]+"|" );
            }
            System.out.println("" );
            for (int j = 0 ; j <  numOfCells ; j++) {
                System.out.print("------");
            }
            System.out.println();
        }
    }

    public static int[][] up (int net[][]){//In this method the program makes some changes inside the net when the user presses button up.In addition, it changes the total score.
        for (int i = 0 ; i < net.length ; i++) {
            for (int j = 0 ; j < net.length ; j++) {
                for (int k = j - 1  ; k >= 0  ; k--) {
                    if (net[k][i] == 0) {
                        net[k][i] = net [k + 1][i];
                        net [k + 1][i] = 0;
                    }
                    if (net[k][i] == net[k + 1][i] )  {
                        net[k][i] = 2 * net[k][i];
                        net [k + 1][i] = 0;
                        score += net[k][i];
                    }
                }
            }
        }
        return net;

    }
    public static int[][] left (int net[][]){//In this method the program makes some changes inside the net when the user presses button left.In addition, it changes the total score.
        for (int i = 0 ; i < net.length ; i++) {
            for (int j = 0 ; j < net.length ; j++) {
                for (int k = j - 1  ; k >= 0  ; k--) {
                    if (net[i][k] == 0) {
                        net[i][k] = net [i] [k+1];
                        net [i] [k+1]= 0;
                    }
                    if (net[i][k] == net[i][k + 1] )  {
                        net[i][k] = 2 * net[i][k + 1];
                        net [i][k + 1] = 0;
                        score += net[i][k];
                    }

                }
            }
        }
        return net;
    }
    public static int[][] down (int net[][]){//In this method the program makes some changes inside the net when the user presses button left.In addition, it changes the total score.
        for (int i = 0 ; i < net.length ; i++) {
            for (int j = net.length - 1;  j >= 0 ; j--) {
                for (int k = j + 1  ; k < net.length  ; k++) {
                    if (net[k][i] == 0) {
                        net[k][i] = net [k - 1][i];
                        net [k - 1][i] = 0;
                    }
                    if (net[k][i] == net[k - 1][i] )  {
                        net[k][i] = 2 * net[k - 1][i];
                        net [k - 1][i] = 0;
                        score += net[k][i];
                    }
                }
            }
        }
        return net;
    }
    public static int[][] right (int net[][]){//In this method the program makes some changes inside the net when the user presses button left.In addition, it changes the total score.
        for (int i = 0 ; i < net.length ; i++) {
            for (int j = net.length - 1 ; j >= 0 ; j--) {
                for (int k = j + 1  ; k < net.length  ; k++) {
                    if (net[i][k] == 0) {
                        net[i][k] = net [i][k - 1];
                        net [i][k - 1]= 0;

                    }
                    if (net[i][k] == net[i][k - 1] )  {
                        net[i][k] = 2 * net[i][k - 1];
                        net [i][k - 1] = 0;
                        score += net[i][k];
                    }

                }
            }
        }
        return net;
    }
    public static  boolean  gameOver (int net[][]){//In this method the program adds the conditions for game over. If the user is unable to make any moves the game ends.
        boolean gameOver = false;
        for(int i = 0; i < net.length - 1; i++) {
            for(int j = 0; j < net.length - 1; j++) {
                if (net[i][j] == 0 || net[i][j] == net[i + 1][j] || net[i][j] == net[i][j + 1]) {
                    gameOver = true;
                    break;
                }

            }
        }
        return gameOver;

    }

    public static  boolean  YouWin (int net[][]){// The user wins when he/she gets 1024.
        boolean winningNum = false;
        for(int i = 0; i < net.length; i++) {
            for(int j = 0; j < net.length; j++) {
                winningNum = net[i][j] == 1024;
                if(winningNum) break;
            }
            if(winningNum) break;

        }
        return winningNum;

    }
}
