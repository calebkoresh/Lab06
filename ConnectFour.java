import java.util.Scanner;

public class ConnectFour {

    public static void printBoard(char[][] array)
    {

        //Print board
        for (int i = array.length - 1; i >= 0; i--)
        {

            for (int j = 0; j < array[0].length; j++)
            {

                System.out.print(array[i][j] + " ");

            }
            System.out.println();

        }

    }

    public static void initializeBoard(char[][] array)
    {

        //Set every value to '-'
        for (int i = 0; i < array.length; i++)
        {

            for (int j = 0; j < array[0].length; j++)
            {

                array[i][j] = '-';

            }

        }

    }

    public static int insertChip(char[][] array, int col, char chipType)
    {

        //Inserts Chip
        for (int i = 0; i < array.length; i++)
        {

            if (array[i][col] == '-')
            {

                array[i][col] = chipType;
                return i;

            }

        }

        return 0;

    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType)
    {

        //Variables
        int numConsecutive = 0;

        //Checks for four in a row
        for (int i = 0; i < array.length; i++)
        {

            if (array[i][col] == chipType)
            {

                numConsecutive++;

            }

            else
            {

                numConsecutive = 0;

            }

            if (numConsecutive == 4)
            {

                return true;

            }

        }

        //Checks for four in a column
        for (int i = 0; i < array[0].length; i++)
        {

            if (array[row][i] == chipType)
            {

                numConsecutive++;

            }

            else
            {

                numConsecutive = 0;

            }

            if (numConsecutive == 4)
            {

                return true;

            }
        }

        //Returns false if there is not four consecutive
        return false;

    }

    public static void main(String[] args) {

        //Variables
        int boardHeight;
        int boardLength;
        int playerTurn = 1;
        int columnChosen;
        int rowPlaced;
        boolean gameWon = false;
        Scanner scnr = new Scanner(System.in);

        //Prompt User for Height and Length
        System.out.print("What would you like the height of the board to be? ");
        boardHeight = scnr.nextInt();
        System.out.println();
        System.out.print("What would you like the length of the board to be? ");
        boardLength = scnr.nextInt();

        //Set max game time
        int maxCapacity = boardHeight * boardLength;

        //Initialize Board and Print
        char[][] gameBoard = new char[boardHeight][boardLength];
        initializeBoard(gameBoard);
        printBoard(gameBoard);
        System.out.println();
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        //Keeps game running until there is a winner
        do
        {

            //Player 1 Turn
            if (playerTurn % 2 == 1)
            {

                System.out.println();
                System.out.print("Player 1: Which column would you like to choose? ");
                columnChosen = scnr.nextInt();
                rowPlaced = insertChip(gameBoard, columnChosen, 'x');
                gameWon = checkIfWinner(gameBoard, columnChosen, rowPlaced, 'x');
                System.out.println();
                printBoard(gameBoard);
                if (gameWon == true)
                {

                    System.out.println();
                    System.out.println("Player 1 won the game!");

                }
            }

            //Player 2 Turn
            if (playerTurn % 2 == 0)
            {

                System.out.println();
                System.out.print("Player 2: Which column would you like to choose? ");
                columnChosen = scnr.nextInt();
                rowPlaced = insertChip(gameBoard, columnChosen, 'o');
                gameWon = checkIfWinner(gameBoard, columnChosen, rowPlaced, 'o');
                System.out.println();
                printBoard(gameBoard);
                if (gameWon == true)
                {

                    System.out.println();
                    System.out.println("Player 2 won the game!");

                }
            }

            playerTurn++; //Determines whose turn it is

            //Declares draw if board fills up without winner
            if (playerTurn == maxCapacity + 1 && gameWon == false)
            {

                System.out.println("Draw. Nobody wins.");
                gameWon = true;

            }

        } while (gameWon == false); //Ends game when there is a winner or draw

    }

}
//git hub change note hi zach hope you have a good day
