package com.onebill.corejava.module1;

import java.util.Collections;
import java.util.Scanner;

public class PlaySong extends GettingSongDetails{


	void playAllSongs(Scanner sc) {
		getTitle();
		Collections.sort(songs);
		playing(sc);
	} 

	void playRandom(Scanner sc) {
		getTitle();
		Collections.shuffle(songs);
		playing(sc);
	}
	
	void playing(Scanner sc) {
		for(int i = 0; i<songs.size(); i++) {
			System.out.println("Playing " + songs.get(i) + " from " + album.get(i) + ".....");
			//Song playing for 20 seconds
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Press any number to stop playing or 0 to end.\nInput :");
			int flag = sc.nextInt();
			if(flag == 0) {
				System.out.println("Playlist stopped playing.");
				break;
			}
			else {
				System.out.println("Next song switched.\n");
			}
		}
	}
	
	void playParticularSong(String s_name) {
		getParticularSong(s_name);
		System.out.println("Playing " + songs.get(0) + " from " + album.get(0) + ".....");
		try 
		{
			Thread.sleep(2000);
			System.out.println("Song Ended.");
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}

}
