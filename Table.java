package util;

import java.util.Scanner;

public class Table {


	static Scanner sc = new Scanner(System.in);

	public static int[] createTable() {
		return createTable(-1);
	}

	public static int[] createTable(int taille) {

		if (taille < 0) {
			System.out.println("Veuillez saisir la taille du tableau");
			taille = sc.nextInt();
		}
		int[] tab = new int[taille];

		// boucle pour remplir le tab
		for (int i = 0; i < tab.length; i++) {
			System.out.println("Saisir une valeur");
			tab[i] = sc.nextInt();
		}
		return tab;
	}

	public static void displayTable(int[] tab) {
		for (int i = 0; i < tab.length; i++) {

			System.out.print("[" + tab[i] + "]");
		}
	}

	public static void displayTableMulti(int[][] tab) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				System.out.print("[" + tab[i][j] + "]");
			}
			System.out.println("");
		}
	}

	public static int[][] creatTableMulti(int positionI, int positionJ) {

		int[][] tab = new int[positionI][positionJ];

		int range = 20 - (0);

		for (int i = 0; i < positionI; i++) {
			for (int j = 0; j < positionJ; j++) {
				tab[i][j] = (int) (Math.random() * range) + 0;
			}

		}
		return tab;
	}

	public static int[] createTableRandomValue() {
		System.out.println("Veuillez saisir la taille du tableau");
		int taille = sc.nextInt();
		int[] tab = new int[taille];
		// int range = 20-0 + 1;
		int range = 50 - (-50);
		// int rand = (int)(Math.random()*range)+0;
		for (int i = 0; i < tab.length; i++) {
			tab[i] = (int) (Math.random() * range) + 0;
		}
		return tab;
	}

	public static int[][] createTableDamier() {
		boolean tailleOk = false;
		int positionI = 0;
		int positionJ=0;
		
		while(!tailleOk) {
			System.out.println("la possition du pion en i (compris entre 0 et 9)");

			positionI = sc.nextInt();
			System.out.println("la possition du pion en j (compris entre 0 et 9)");
			positionJ = sc.nextInt();
			if (positionI > 10 || positionI < 0 || (positionJ > 10 || positionJ < 0)) {
				System.out.println("la possition entré n'est pas bonne");

			}else {
				tailleOk =true;
			}
		}
		

		int[][] tab = new int[10][10];

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (i == positionI && j == positionJ) {
					tab[i][j] = 1;
				} else {
					tab[i][j] = 0;
				}
				System.out.print("["+tab[i][j]+"]");
			}
			System.out.println("");
		}
		return tab;
	}

	public static void deplacementDamier(int[][] tab) {
		int positionI = 0;
		int positionJ = 0;
		boolean fin = false;
		
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (tab[i][j] == 1) {
					positionJ = j;
					positionI = i;
					i = tab.length;
					j = tab[0].length;
				}
			}
		}

		while (fin != true) {
			System.out.println(
					"quel mouvement voulez-vous effectuer : 0 (en haut � gauche), 1(en haut � droite), "
					+ "2 (en bas � gauche), 3 (en bas � droite), 4 (arr�t du jeu)");
			
			int deplacement = sc.nextInt();
			switch (deplacement) {
			case 4:
				Table.displayTableMulti(tab);
				fin = true;
			default:
				break;
			case 1:
				if (positionI - 1 >= 0 && positionJ + 1 <= 9) {
					tab[positionI][positionI] = 0;
					tab[positionI - 1][positionJ + 1] = 1;
					positionJ++;
					positionI--;
				} else {
					System.out.println("mouvement impossible");
				}
				break;
			case 0:
				if ((positionI - 1) >= 0 && (positionJ - 1) <= 9) {
					tab[positionI][positionJ] = 0;
					tab[positionI - 1][positionJ - 1] = 1;
					positionJ--;
					positionI--;
				} else {
					System.out.println("mouvement impossible");
				}
				break;
			case 3:
				if (positionI + 1 <= 9 && positionJ + 1 <= 9) {
					tab[positionI][positionJ] = 0;
					tab[positionI + 1][positionJ + 1] = 1;
					positionJ++;
					positionI++;
				} else {
					System.out.println("mouvement impossible");
				}
				break;
			case 2:
				if (positionI + 1 <= 9 && positionJ - 1 >= 0) {
					tab[positionI][positionJ] = 0;
					tab[positionI + 1][positionJ - 1] = 1;
					positionJ--;
					positionI++;
				} else {
					System.out.println("mouvement impossible");
				}
				break;
			}
			Table.displayTableMulti(tab);
		}
	}
}
