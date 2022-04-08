package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Scoreboard {

	public static void main(String[] args) {

		ArrayList<String> scoreList = new ArrayList<String>();

		allProcess(scoreList);

	}

	public static ArrayList<String> scoreRecord(ArrayList scoreList) {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Input student name and score : ");
			String nameNscore = sc.nextLine();
			scoreList.add(nameNscore);
			System.out.println("If you want to stop input process, press 0");
			System.out.println("Otherwise, press any key");
			String stopQ = sc.next();
			if (stopQ.contains("0")) {
				break;
			}
		}
		return scoreList;
	}

	public static void descendingSort(ArrayList<String> scoreList) {
		for (int i = 0; i < scoreList.size(); i++) {
			for (int j = 0; j < scoreList.size() - 1; j++) {
				if (Integer.parseInt(scoreList.get(j).replaceAll("[^0-9]", "")) < 
						Integer.parseInt(scoreList.get(j + 1).replaceAll("[^0-9]", ""))) {
					String temp = scoreList.get(j);
					scoreList.set(j, scoreList.get(j + 1));
					scoreList.set(j + 1, temp);
				}
			}
		}
	}

	public static void showRanking(ArrayList<String> scoreList) {
		System.out.println("\nRank : ");

		for (int i = 0; i < scoreList.size(); i++) {
			System.out.print((i+1) + "." + scoreList.get(i).replaceAll("[0-9]", "") + " ");
		}
	}
	
	public static void allProcess (ArrayList <String> scoreList) {
		
		scoreRecord(scoreList);

		descendingSort(scoreList);

		showRanking(scoreList);
	
	}
}
