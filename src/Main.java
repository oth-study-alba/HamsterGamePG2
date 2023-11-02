import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Map map = Map.getInstance();
    Player player = Player.getInstance();
    int moves = 0;

    System.out.println("Welcome to Hamster Munch!");
    System.out.println();
    System.out.println("Controls: A = Rotate Left, D = Rotate Right, W = Move Forward");
    System.out.println("Walk over the ⚘ nuts to collect them!");
    System.out.println("Collect all nuts to win!");

     while(player.getScore() < 7)
   {
        map.renderRoom();
        Scanner input = new Scanner(System.in);
        player.control(input.nextLine());
        moves++;
   }
    System.out.println();
     System.out.println("Congratulations, you won!");
     System.out.println();
     System.out.println("It took you " + moves + " moves to collect all nuts!");




    }
}