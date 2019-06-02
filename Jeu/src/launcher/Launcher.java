package launcher;

import java.util.Scanner;

import game.Game;

public class Launcher {

public static void main(String[] args) {
	Game game= new Game();
	game.start();
	Scanner sc = new Scanner(System.in);
	System.out.println("Vouliez<-vous continuer ? ");
	System.out.println("1: Oui! ");
	System.out.println("2: Non! ");
	int choix = sc.nextInt();
	if(choix==1) game.restart();
	else System.out.println("-----------END-------------");
}
}
