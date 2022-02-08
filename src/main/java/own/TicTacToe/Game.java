package own.TicTacToe;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    Board table;
    Player[] players;
    Player actualPlayer;
    boolean ended;

    {
        table = new Board();
        players = new Player[]{
                new Player(Players.Player1, Emblem.X),
                new Player(Players.Player2, Emblem.O)
        };
        actualPlayer = players[0];
        ended = false;
    }

    public void Start(){
        while (!ended){
            System.out.println(table.ToString());
            System.out.println(actualPlayer.name + " válasszon egy mezőt:");
            Scanner in = new Scanner(System.in);
            String be = in.nextLine();
            int beConverted = 0;
            try {
                beConverted = Integer.parseInt(be);
            } catch (NumberFormatException nfe){
                System.out.println("Kérlek számot adj meg");
            }
            if (table.ValidPosition(beConverted))
                if (table.GuessAndCheck(beConverted, actualPlayer)){
                    ended = true;
                }
                else{
                    SwitchPlayer();
                }
            else{
                System.out.println("Kérlek egy létező pozíctiót adj meg");
            }
            try {
                Thread.sleep(900);
            }
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            System.out.flush();
        }
        System.out.println(table.ToString());
        System.out.println("Gratulálunk, " + actualPlayer.name + " nyert");
    }
    private void SwitchPlayer(){
        actualPlayer = actualPlayer.name == Players.Player1 ? players[1] : players[0];
    }
}
