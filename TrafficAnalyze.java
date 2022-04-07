package day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TrafficAnalyze {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\trafficvolume.csv"));
		ArrayList<Integer> list = new ArrayList<Integer>();
		String line;

		while ((line = reader.readLine()) != null) {
			if (line.contains(",목,")) {
				String[] trafficArray = line.split(",");
				try {
					if (trafficArray[20] != null)
					list.add(Integer.parseInt(trafficArray[20]));
				} catch (Exception e) {
					
				}
			}
		}

		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}

		Collections.sort(list);
		System.out.println("최대값 : " + list.get(0));
		Collections.reverse(list);
		System.out.println("최소값 : " + list.get(0));
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum / list.size());
	}
}