package game;

import java.util.Scanner;

import grid.Grid;
import instance.Input;
import player.Player;

public class Game {
	private Grid grid;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	
	
/**
 * constructeur
 */
public Game() {
	this.grid = new Grid();
	Scanner sc = new Scanner(System.in);
	System.out.println("Entrer le nom du joueur 1: ");
	String name = sc.nextLine();
	this.player1= new Player(1, name, 'X');
	System.out.println("Entrer le nom du joueur 2: ");
	String name1 = sc.nextLine();
	this.player2= new Player(2, name1, 'O');
}	

/**
 * Permet d'initialiser le tour de chaque joueur jusqu'à la fin du jeu
 */
private void swapTurn() {
	if(currentPlayer.equals(this.player1))
		this.currentPlayer=player2;
	else
		this.currentPlayer=player1;
	
}


/**permet de récupérer l'instance de chaque joueur
 * @param sc
 * @return
 */
private  int getPlayerInput(Scanner sc) {
	int input = -1;
	 sc=new Scanner(System.in);
	while(true) {
		System.out.println("Player ' " + this.currentPlayer.getName()+ "("+this.currentPlayer.getChoice()+")"+ "' ,your turn: ");
		  input = Input.readInt(sc);
		  if(input>=1 && input<=9)
		break;
	}
	return (input-1);
}

/**
 * permet d'afficher le plateau
 */
private void printGrid() {
	System.out.flush();
	System.out.println(this.grid);

}
/**
 * Permet d'initialiser le jeu
 */
public void start() {
	 currentPlayer=player1;
	 Scanner sc = new Scanner(System.in);
	 while(true) {
		
		 printGrid();
		 int input = getPlayerInput(sc);
		
		 this.grid.setCaseChoice(input, this.currentPlayer.getChoice());
		 
		 if(this.grid.getWinner()!=null) {
			 System.out.println(" Player '"+ this.currentPlayer.getName()+ " " +"("+this.currentPlayer.getChoice()+")"+"' won the game, congrats!");
			 printGrid();
			 break;
		 }
		 else if(this.grid.isFull()) {
			
			 printGrid();
			 
			 System.out.println("Nobody won!!!!");
			 break;
		 }
		 swapTurn();
	 }
	

}

/**
 * permet de retablir les valeur du tableau par defaut
 */
public void reset() {
	this.grid.clear();
	}
public void restart() {
	reset();
	printGrid();
	start();
}
}
