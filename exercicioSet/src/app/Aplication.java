package app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Aplication {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		//System.out.print("File path: ");
		String path = "D://Temp//in.txt";
		Set<LogEntry> set = new HashSet<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String name = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				set.add(new LogEntry(name, moment));
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println(set.size());

	}

}
