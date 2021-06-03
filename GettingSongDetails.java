package com.onebill.corejava.module1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GettingSongDetails {

	ResultSet srs = PlayerInitialization.rs;
	Statement ssmt = PlayerInitialization.smt;
	PreparedStatement psmt = null;

	ArrayList<String> songs = new ArrayList<String>();
	ArrayList<String> album = new ArrayList<String>();
	ArrayList<String> artist = new ArrayList<String>();
	ArrayList<Integer> id = new ArrayList<Integer>();

	void getTitle() {

		try {
			srs = ssmt.executeQuery("select song_title,album_name from songs");
			while(srs.next()) {
				songs.add(srs.getString("song_title"));
				album.add(srs.getString("album_name"));
			}
		} catch (SQLException e) {
			//SQL Exception occurred
			System.err.println("Sorry! Something went wrong.");
		}

	}

	void getParticularSong(String name) {
		try {
			psmt = PlayerInitialization.con.prepareStatement("select song_title,album_name "
					+ "from songs where song_title=?");
			psmt.setString(1, name);
			srs = psmt.executeQuery();
			while(srs.next()) {
				songs.add(srs.getString("song_title"));
				album.add(srs.getString("album_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//getting all song's details using title
	void getAll(String name) {
		try {
			psmt = PlayerInitialization.con.prepareStatement("select song_title, artist_name, "
					+ "album_name, song_id from songs where song_title=?");
			psmt.setString(1, name);
			srs = psmt.executeQuery();
			while(srs.next()) {
				id.add(srs.getInt("song_id"));
				songs.add(srs.getString("song_title"));
				artist.add(srs.getString("artist_name"));
				album.add(srs.getString("album_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//get all sorted by title
	void getAllSorted() {
		try {
			srs = ssmt.executeQuery("select * from songs");
			ArrayList<SongDatabase> sd = new ArrayList<SongDatabase>();
			while(srs.next()) {
				sd.add(new SongDatabase(srs.getInt("song_id"), srs.getString("song_title"), srs.getString("artist_name"),
						srs.getString("album_name"), srs.getString("song_location"), srs.getString("description")));
			}
			Comparator<SongDatabase> com = new Comparator<SongDatabase>() {


				@Override
				public int compare(SongDatabase o1, SongDatabase o2) {
					int temp = o1.sname.compareTo(o2.sname);
					if(temp>0)
						return 1;
					else 
						return -1;
				}
			};
			Collections.sort(sd, com);
			System.out.println(" ID\tTitle\t\t\tArtist\t\tAlbum\t\tLocation\tDescription");

			for(int i = 0; i<sd.size();i++) {
				System.out.println(sd.get(i).id + "\t" + sd.get(i).sname + "\t\t\t" + sd.get(i).sartist +
						"\t\t" + sd.get(i).salbum + "\t\t" + sd.get(i).slocation + "\t" + sd.get(i).sdescription);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	//Adding data to playlist
	void addSong(String name, String artist, String album, String loc, String desc) {
		try {
			psmt = PlayerInitialization.con.prepareStatement("\"insert into songs(song_title, artist_name ," + 
					" album_name , song_location , description ) values(?, ?, ?, ?, ?)");

			psmt.setString(1, name);
			psmt.setString(2, artist);
			psmt.setString(3, album);
			psmt.setString(4, loc);
			psmt.setString(5, desc);
			psmt.execute();
			System.out.println("Song added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
