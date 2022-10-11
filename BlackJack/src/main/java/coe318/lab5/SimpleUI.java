package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
      System.out.println("House Holds: \n" + this.game.getHouseCards().toString()+"\n");
      System.out.println("You Hold: \n" + this.game.getYourCards().toString()+"\n"); 
    }

  @Override
    public boolean hitMe() {
        System.out.println("Another card? (input y/n)"+"");
        String in = user.nextLine().toLowerCase();
        if (in.equals("n"))
            return false;
        else if (in.equals("y"))
            return true;
        else
            return hitMe();
    }

  @Override
    public void gameOver() {
        this.display();
        int player = game.score(game.getYourCards());
        int house = game.score(game.getHouseCards());
        
        
        System.out.println(" Your Score: " + player +"\n" +"House Score: " + house );
        
        
        
        if( (player > house || house > 21) && (player <= 21) )
                {
            System.out.println("You win!");
        }else{
            System.out.println("The House Wins!");
        }
      

    }

}