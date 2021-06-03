package com.onebill.corejava.module1;

import java.util.Scanner;

public class SearchSong extends GettingSongDetails {
	
	void search(Scanner sc) {
		System.out.println("Enter Song name : ");
		String s_title = sc.next();
		getAll(s_title);
		
		System.out.println("+------------+---------+------+----------------+-------------+");
		System.out.println("| File Name\tTitle\tArtist\tAlbum\t\tUnique Number");
		System.out.println("+------------+---------+------+----------------+-------------+");
		for(int i = 0; i<songs.size();i++) {
			System.out.println("| " + songs.get(i) + ".mp3\t" + songs.get(i) + "\t" + artist.get(i) +
					"\t" + album.get(i) + "\t\t" + id.get(i));
		}
		System.out.println("+------------+---------+------+----------------+-------------+");
	}
}
