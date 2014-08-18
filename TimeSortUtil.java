package assignment4;

import java.util.ArrayList;
import java.util.Random;

import assignment3.CollectionArray;
import assignment3.IntegerComparator;
import assignment3.SearchUtil;

/**
 * Time the code
 * 
 * @date 5/31/2013
 * @author Leland Stenquist, Daryl Bennett
 * 
 */
public class TimeSortUtil
	{
		
		public static void main(String[] args) {
			
			//keep track of averages
			double averageTimeQuickSort = 0;
			double averageTimeMergeSortThresh = 0;
		
			//set size of lists
			for (int i = 10000; i <= 250000; i = i + 10000) {
				//call method to do work
					averageTimeMergeSortThresh = testMergeSort(i);

				System.out.println(averageTimeMergeSortThresh);
			}
			System.out.println("MergeSort done");

			//set size of lists
			for (int i = 10000; i <= 250000; i = i + 10000) {
				//call method to do work
					averageTimeQuickSort = testQuickSort(i);

			System.out.println(averageTimeQuickSort);
			}
			 System.out.println("QuickSort done");
		}

		/**
		 * This method creates a list and sorts it using mergesort returning the time
		 * 
		 * @param in
		 *            the amount in the array
		 * @return time the amount of time it took to sort the list
		 */
		public static double testMergeSort(int in) {
			
			//declare variables
			long startTime, stopTime;
			int timesToLoop = 12;

			//start timing
			startTime = System.nanoTime();

			ArrayList<Integer> test = SortUtil.generateAverageCase(in);

			// System.out.println(test);
			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			// Now, run the test.
			startTime = System.nanoTime();
			
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.mergesort(test);
				test = SortUtil.generateAverageCase(in);
			}

			long midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
				test = SortUtil.generateAverageCase(in);
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime = (((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop) / 1000000;

			return averageTime;


		}

		/**
		 * This method creates a list and sorts it using quicksort returning the time
		 * 
		 * @param in
		 *            the amount in the array
		 * @return time the amount of time it took to see if the list contained
		 *         a random object
		 */
		public static double testQuickSort(int in) {
			
			//declare variables
			long startTime, stopTime;
			int timesToLoop = 12;

			
			ArrayList<Integer> test = SortUtil.generateAverageCase(in); // create a CollectionArray
			
			// start time
			startTime = System.nanoTime();

			// First, spin computing stuff until one second has gone by.
						// This allows this thread to stabilize.
			while (System.nanoTime() - startTime < 1000000000) {
			} // empty block

			startTime = System.nanoTime();
			
			// Now, run the test.
			for (int i = 0; i < timesToLoop; i++) {
				SortUtil.quicksort(test);
				test = SortUtil.generateAverageCase(in);
			}

			long midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.
			for (long i = 0; i < timesToLoop; i++) {
				test = SortUtil.generateAverageCase(in);
			} // empty block

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.
			double averageTime = (((midpointTime - startTime) - (stopTime - midpointTime))
					/ timesToLoop) / 1000000;

			return averageTime;

		}

	}
