package com.geekTrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Geektrust {

	private Solution sol = new Solution();

	private void getDetails(String[] arr) {

		if (arr[0].equals("FASTAG")) {
		//	System.out.println(arr[2]);
			sol.registerVhicle(arr[1], Integer.parseInt(arr[2]));

		} else if (arr[0].equals("COLLECT_TOLL")) {
			try {

				sol.collectToll(arr[2], arr[1]);

			} catch (NoVehicleTypeFound e) {

				System.out.println("No Vhicle found");

			}
		} else {
			sol.print();
		}
	}

	public static void main(String[] args) {
		Geektrust gt = new Geektrust();
		try {

			FileInputStream fis = new FileInputStream(args[0]);
			Scanner sc = new Scanner(fis);

			while (sc.hasNextLine()) {

				String inputCommand = sc.nextLine();

				String[] arr = inputCommand.split(" ");
			//	System.out.println(inputCommand);

				gt.getDetails(arr);
			}
			sc.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
