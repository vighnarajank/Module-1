package com.onebill.corejava.module1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class PlayerInitialization {

	static Connection con = null;
	static Statement smt = null;
	static ResultSet rs = null;

	protected static void createPlaylist() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//in case of executing in your computer just change the user name and password alone
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "admin");
			smt = con.createStatement();
			try{

				//playlist database creation
				boolean bool = smt.execute("create database playlist");

				if(bool == true) {
					throw new Exception(); 
				}
				else{
					System.out.println("Playlist created successfully.");
					initializePlaylist();


				}
			} catch (Exception e){
				System.out.println("'Playlist' database already present.");
				initializePlaylist();

			}


		} catch (ClassNotFoundException e) {
			//Class not found Exception
			System.err.println("Sorry! Something went wrong.");
		} catch (SQLException e1) {
			//SQLException found
			System.err.println("Sorry! Something went wrong.");
		}

	}

	protected static void initializePlaylist() {
		try {
			
			//using database 'playlist'
			smt.execute("use playlist");
			System.out.println("Database Changed");
			
			try {
				
				//creating songs table
				boolean bool = smt.execute("create table songs(song_id int(10) auto_increment primary key, "
						+ "song_title varchar(50), artist_name varchar(50), album_name varchar(50), "  
						+ "song_location varchar(50), description varchar(250))");
				if(bool == true) {
					throw new Exception(); 
				}
				else{
					System.out.println("'songs' table created successfully.");

				}
				
			} catch (Exception e){}

			rs = smt.executeQuery("select song_title from songs where song_id=1");
			if(rs.next())	//Checking whether default playlist has some songs
			{
				System.out.println("Playlist has some songs");
			}
			else {			//If table is empty inserting songs

				//inserting songs
				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Unakena naan', 'Maran', 'Shades of Kadhal', 'D:\\Songs', 'Pop')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Neethaney', 'Shreya Goshal', 'Mersal', 'D:\\Songs', 'Melody')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Kangal Irandaal', 'James', 'Subramaniyapuram', 'D:\\Songs', 'Melody')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Sara sara saara kaathu', 'Chinmayi', 'Vaagai sooda vaa', 'D:\\Songs', 'Melody')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Kutty Pattas', 'Santhosh', 'Kutty Pattas', 'D:\\Songs', 'Pop')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Vilambara Idaiveli', 'Aadhi', 'Imaikaa Nodigal', 'D:\\Songs', 'Pop')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Yaanji', 'Anirudh', 'Vikram Vedha', 'D:\\Songs', 'Rock')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Tasaku Tasaku', 'Mugesh', 'Vikram Vedha', 'D:\\Songs', 'Rock')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Kannama', 'Anirudh', 'Ispade Rajavum Idhaya Ranium', 'D:\\Songs', 'Pop')");

				smt.execute("insert into songs(song_title, artist_name , "
						+ "album_name , song_location , description ) "
						+ "values('Yaanji', 'Anirudh', 'Vanakam Chennai', 'D:\\Songs', 'Melody')");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//			finally {
//
//			try {
//				if(con != null)
//					con.close();
//				if(smt != null)
//					smt.close();
//				if(rs != null)
//					rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}


	}

}
