package com.onebill.corejava.module1;

import java.util.Scanner;

public class HenceForth {

	public static void main(String[] args) {

		/*
		 * To Create database in your computer go to the 'PlayerInitialization' Class
		 * and change the user name and password alone
		 */

		//Create & Initialize a default database & table with some songs
		PlayerInitialization.createPlaylist();

		//Business logic
		System.out.println();
		System.out.println("Welcome to HenceForth");
		Scanner sc = new Scanner(System.in);
		
		boolean outbool = true;
		boolean inbool = true;

		SearchSong ss = new SearchSong();
		DBOperations dbo = new DBOperations();
		PlaySong ps = new PlaySong();

		while(outbool == true) {
			System.out.println("1. Play a Song\n" + 
					"2. Search a Song\n" + 
					"3. Show all Songs\n" + 
					"4. Operate on Songs Database\n" +
					"5. Exit \nInput :");
			int choice = sc.nextInt();

			switch(choice) {

			case 1:
				while(inbool == true) {
					System.out.println("What would you like to do?");
					System.out.println("A. Play all songs\n" + 
							"B. Play Songs Randomly\n" + 
							"C. Play a Particular Song\n" +
							"D. Back \nInput :");


					char ch = sc.next().toUpperCase().charAt(0);	//small case input also accepted

					switch (ch) {
					case 'A':
						ps.playAllSongs(sc);
						break;

					case 'B':
						ps.playRandom(sc);
						break;	
						
					case 'C':
						
						//plays first particular song from the playlist
						System.out.println("Enter Song name : ");
						String s_name = sc.next();
						ps.playParticularSong(s_name);
						break;
						
					case 'D':
						inbool = false;
					default:
						//inner while
						System.out.println("Enter correct Choice.");
						break;
					}

				}
				break;

			case 2:
				ss.search(sc);
				break;

			case 3:
				ss.getAllSorted();
				break;

			case 4:
				inbool = true;
				while(inbool == true) {
					System.out.println("A. Add Song\n" + 
							"B. Edit an existing Song\n" + 
							"C. Delete an existing Song\nInput :");
					char choose = sc.next().toUpperCase().charAt(0);
					switch (choose) {
					case 'A':
						dbo.adding();
						break;

					case 'B':

						break;	
					case 'C':

						break;
					default:
						//inner while
						break;
					}
				}
				break;

			case 5:
				System.out.println("Thankyou for choosing HenceForth");
				outbool = false;
				break;

			default:
				//outer while
				System.out.println("Enter correct Choice.");
				break;
			}

		}
		sc.close();
	}

}
