import java.security.PublicKey;
import java.util.Scanner;

public class MazeRunner {
    private static Maze myMap = new Maze();

    public static void main(String[] args) {

        myMap.printMap();

        System.out.println("hello friend");

        for (int i=0;i<100;i++) {

            System.out.println("your counter is :"+i );
            movesMessage(i);
            if (myMap.didIWin()) {
                System.out.println("Congratulations, you made it out alive!");
                System.out.println("and you did it in " + i + " moves");
                return;
            } else {
                String choice = userMove();
                if(myMap.isThereAPit(choice))
                {
                    navigatePit(choice);
                }
                switch (choice) {
                    case "R":
                        if (myMap.canIMoveRight()) {
                            myMap.moveRight();
                            myMap.printMap();
                        } else {
                            System.out.println("Sorry, you’ve hit a wall.");
                        }
                        break;
                    case "L":
                        if (myMap.canIMoveLeft()) {
                            myMap.moveLeft();
                            myMap.printMap();
                        } else {
                            System.out.println("Sorry, you’ve hit a wall.");
                        }
                        break;
                    case "U":
                        if (myMap.canIMoveUp()) {
                            myMap.moveUp();
                            myMap.printMap();
                        } else {
                            System.out.println("Sorry, you’ve hit a wall.");
                        }
                        break;
                    case "D":
                        if (myMap.canIMoveDown()) {
                            myMap.moveDown();
                            myMap.printMap();
                        } else {
                            System.out.println("Sorry, you’ve hit a wall.");
                        }
                        break;
                }
            }
        }
        System.out.println("Sorry, but you didn't escape in time- you lose!");
    }
    public static void navigatePit(String choice)
    {
        String answer;
        do {
            System.out.println("Watch out! There's a pit ahead, jump it?\n");
            Scanner sc = new Scanner(System.in);
            answer = sc.nextLine();
        }
        while(!(answer.startsWith("Y")));
        myMap.jumpOverPit(choice);
    }

    public static String userMove() {

        String choice;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Where would you like to move? (R, L, U, D)");
            choice = sc.nextLine();
        }
        while (!(choice.equals("R") || choice.equals("L") || choice.equals("U") || choice.equals("D")));
        return choice;
    }

    public static void movesMessage(int moves) {
        switch (moves) {
            case 50:
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
                break;
            case 75:
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            case 90:
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            case 100:
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                break;
        }
    }
}
