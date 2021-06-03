package com.onebill.corejava.module1;

import java.util.Scanner;

public class DBOperations extends GettingSongDetails{

		void adding() {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter song Name : ");
			String sngname = s.next();
			System.out.println("Enter song Artist : ");
			String sngartist = s.next();
			System.out.println("Enter song Album : ");
			String sngalbum = s.next();
			System.out.println("Enter song Location : ");
			String snglocation = s.next();
			System.out.println("Enter song Description : ");
			String sngdesc = s.next();
			addSong(sngname,sngartist,sngalbum,snglocation,sngdesc);
			s.close();
	}

}
