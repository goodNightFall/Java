package Laba5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	private static final int[] COLLECTION_SIZES = { 10, 100, 1000, 10000, 100000 };
	private static List<Integer> scores_array_add = new ArrayList<>();
	private static List<Integer> scores_array_remove = new ArrayList<>();
	private static List<Integer> scores_array_total_add = new ArrayList<>();
	private static List<Integer> scores_array_total_remove = new ArrayList<>();

	private static List<Integer> scores_linked_add = new ArrayList<>();
	private static List<Integer> scores_linked_remove = new ArrayList<>();
	private static List<Integer> scores_linked_total_add = new ArrayList<>();
	private static List<Integer> scores_linked_total_remove = new ArrayList<>();

	public static void main(String[] args) {

		for (int collectionSize : COLLECTION_SIZES) {

			ArrayList<Vehicle> vehicleList = new ArrayList<>();
			FillRandomList(vehicleList, collectionSize);

			LinkedList<Vehicle> vehicleLinked = new LinkedList<>();
			FillRandomLinked(vehicleLinked, collectionSize);
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				Collections.reverse(scores_array_add);
				Collections.reverse(scores_linked_add);

				DrawGraph add_array_Panel = new DrawGraph(scores_array_add);
				DrawGraph add_linked_Panel = new DrawGraph(scores_linked_add);

				add_array_Panel.setPreferredSize(new Dimension(800, 600));
				add_linked_Panel.setPreferredSize(new Dimension(800, 600));
				JFrame frame = new JFrame("Среднее время добавления элемента ArrayList и LinkedList");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(add_array_Panel, BorderLayout.NORTH);
				frame.add(add_linked_Panel, BorderLayout.CENTER);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

				Collections.reverse(scores_array_remove);
				Collections.reverse(scores_linked_remove);
				DrawGraph remove_array_Panel = new DrawGraph(scores_array_remove);
				DrawGraph remove_linked_Panel = new DrawGraph(scores_linked_remove);

				remove_array_Panel.setPreferredSize(new Dimension(800, 600));
				remove_linked_Panel.setPreferredSize(new Dimension(800, 600));
				JFrame frame2 = new JFrame("Среднее время удаления элемнта ArrayList и LinkedList");
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame2.add(remove_array_Panel, BorderLayout.NORTH);
				frame2.add(remove_linked_Panel, BorderLayout.CENTER);
				frame2.pack();
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);

				Collections.reverse(scores_array_total_add);
				Collections.reverse(scores_linked_total_add);
				DrawGraph add_array_total_Panel = new DrawGraph(scores_array_total_add);
				DrawGraph add_linked_total_Panel = new DrawGraph(scores_linked_total_add);

				add_array_total_Panel.setPreferredSize(new Dimension(800, 600));
				add_linked_total_Panel.setPreferredSize(new Dimension(800, 600));
				JFrame frame3 = new JFrame("Общее время добавления элемента ArrayList и LinkedList");
				frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame3.add(add_array_total_Panel, BorderLayout.NORTH);
				frame3.add(add_linked_total_Panel, BorderLayout.CENTER);
				frame3.pack();
				frame3.setLocationRelativeTo(null);
				frame3.setVisible(true);

				Collections.reverse(scores_array_total_remove);
				Collections.reverse(scores_linked_total_remove);
				DrawGraph remove_array_total_Panel = new DrawGraph(scores_array_total_remove);
				DrawGraph remove_linked_total_Panel = new DrawGraph(scores_linked_total_remove);

				remove_array_total_Panel.setPreferredSize(new Dimension(800, 600));
				remove_linked_total_Panel.setPreferredSize(new Dimension(800, 600));
				JFrame frame4 = new JFrame("Общее время удаления элемнта ArrayList и LinkedList");
				frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame4.add(remove_array_total_Panel, BorderLayout.NORTH);
				frame4.add(remove_linked_total_Panel, BorderLayout.CENTER);
				frame4.pack();
				frame4.setLocationRelativeTo(null);
				frame4.setVisible(true);
			}
		});
	}

	public static void FillRandomList(ArrayList<Vehicle> vehicleList, Integer numberOfObjects) {
		Random generateNum = new Random();
		String fname = "Laba5/Logs/ArrayList" + numberOfObjects + ".log";

		Long startTime = System.nanoTime();

		for (Integer i = 0; i < numberOfObjects; i++) {
			int leftLimit = 97;
			int rightLimit = 122;
			int targetStringLength = 10;
			Random random = new Random();

			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();

			Long startCurrLong = System.nanoTime();

			vehicleList.add(new Vehicle(generateNum.nextInt(1000), generatedString, generatedString,
					generateNum.nextInt(1000), generateNum.nextInt(1000), generateNum.nextInt(1000)));

			Long endCurrLong = System.nanoTime();
			LogsFile.AddLog(fname, i, endCurrLong - startCurrLong);
		}

		Long endTime = System.nanoTime();
		LogsFile.AddTotalLog(fname, endTime - startTime);
		LogsFile.AddMediumLog(fname, (endTime - startTime) / numberOfObjects);

		scores_array_total_add.add((int) (endTime - startTime));
		scores_array_add.add((int) (endTime - startTime) / numberOfObjects);

		Long startRemoveTime = System.nanoTime();

		for (Integer i = 0; i < vehicleList.size() * 0.1; i++) {
			Long startRemoveCurrLong = System.nanoTime();

			vehicleList.remove(new Random().nextInt(vehicleList.size()));

			Long endRemoveCurrLong = System.nanoTime();
			LogsFile.removeLog(fname, new Random().nextInt(vehicleList.size()),
					endRemoveCurrLong - startRemoveCurrLong);
		}

		Long endRemoveTime = System.nanoTime();
		LogsFile.RemoveTotalLog(fname, endRemoveTime - startRemoveTime);
		LogsFile.RemoveMediumLog(fname, (endRemoveTime - startRemoveTime) / numberOfObjects);

		scores_array_total_remove.add((int) (endRemoveTime - startRemoveTime));
		scores_array_remove.add((int) (endRemoveTime - startRemoveTime) / numberOfObjects);
	}

	public static void FillRandomLinked(LinkedList<Vehicle> vehicleLinked, Integer numberOfObjects) {
		Random generateNum = new Random();
		String fname = "Laba5/Logs/LinkedList" + numberOfObjects + ".log";

		Long startTime = System.nanoTime();

		for (Integer i = 0; i < numberOfObjects; i++) {
			int leftLimit = 97;
			int rightLimit = 122;
			int targetStringLength = 10;
			Random random = new Random();

			String generatedString = random.ints(leftLimit, rightLimit + 1)
					.limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString();

			Long startCurrLong = System.nanoTime();

			vehicleLinked.add(new Vehicle(generateNum.nextInt(1000), generatedString, generatedString,
					generateNum.nextInt(1000), generateNum.nextInt(1000), generateNum.nextInt(1000)));

			Long endCurrLong = System.nanoTime();
			LogsFile.AddLog(fname, i, endCurrLong - startCurrLong);
		}

		Long endTime = System.nanoTime();
		LogsFile.AddTotalLog(fname, endTime - startTime);
		LogsFile.AddMediumLog(fname, (endTime - startTime) / numberOfObjects);

		scores_linked_add.add((int) (endTime - startTime) / numberOfObjects);
		scores_linked_total_add.add((int) (endTime - startTime));

		Long startRemoveTime = System.nanoTime();

		for (Integer i = 0; i < vehicleLinked.size() * 0.1; i++) {
			Long startRemoveCurrLong = System.nanoTime();

			vehicleLinked.remove(new Random().nextInt(vehicleLinked.size()));

			Long endRemoveCurrLong = System.nanoTime();
			LogsFile.removeLog(fname, new Random().nextInt(vehicleLinked.size()),
					endRemoveCurrLong - startRemoveCurrLong);
		}

		Long endRemoveTime = System.nanoTime();
		LogsFile.RemoveTotalLog(fname, endRemoveTime - startRemoveTime);
		LogsFile.RemoveMediumLog(fname, (endRemoveTime - startRemoveTime) / numberOfObjects);

		scores_linked_remove.add((int) (endRemoveTime - startRemoveTime) / numberOfObjects);
		scores_linked_total_remove.add((int) (endRemoveTime - startRemoveTime));
	}
}
