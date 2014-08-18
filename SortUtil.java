package assignment4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 * This class creates a insertionsort, mergesort, and a quicksort.  The insertion
 * sort is to be used in the mergesort and the quicksort.
 * 
 * @date 6/13/2013
 * @author Leland Stenquist, Daryl Benett
 */
public class SortUtil
	{
		private static int threshold = 150;  // this is machine dependant, but the
											// book recomends 10
		public static int pivotCase;    // set pivot case for quicksort

		/**
		 * Helper insertion sort method.
		 * 
		 * @param arr
		 *            - input ArrayList of objects
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 */
		private static <T extends Comparable<? super T>> void insertionsort(
				ArrayList<T> arr, int left, int right) {
			// we must still implement the left and right variables, somehow.
			for (int i = left; i <= (right); i++) {
				T key = arr.get(i); // tmp variable
				int j = i;
				for (j = i - 1; j >= left /* && data[j] > key */; j--) {
					if (arr.get(j).compareTo(key) <= 0) // compares unsorted
														// array with sorted
						break;
					arr.set(j + 1, arr.get(j)); // swap
				}
				arr.set(j + 1, key);
			}
			// TODO:
		}

		/**
		 * MergSort algorithm driver.
		 * 
		 * @param arr
		 *            - input ArrayList of objects
		 */
		public static <T extends Comparable<? super T>> void mergesort(
				ArrayList<T> arr) {
			// is the parameter array null or have only 1 value or less?
			if (arr == null || arr.size() <= 0)
				return;
			// what is the threshold?
			// call insertion sort if the list is small
			if (arr.size() < threshold) {
				// System.out.println("InsertionSort was called");
				insertionsort(arr, 0, arr.size()-1);
				return;
			}
			// System.out.println("MergeSort was called");

			ArrayList<T> iDontKnowWhyImUsingThis_tmp = new ArrayList();
			// This tmp array needs to be the same size as the parameter array

			T someValue = null; // random variable to
			for (int i = 1; i <= arr.size(); i++)
				// will automatically make tmp array same size as parameter
				// array
				iDontKnowWhyImUsingThis_tmp.add(someValue);

			mergesort(arr, iDontKnowWhyImUsingThis_tmp, 0, arr.size() - 1);
			// because of the index we take 0 into account

			// threshold++;

		}

		/**
		 * Main mergeSort method. Makes recursive calls.
		 * 
		 * @param arr
		 *            - input ArrayList of objects
		 * @param temp
		 *            - temporary ArrayList to hold the merged result
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 */
		private static <T extends Comparable<? super T>> void mergesort(
				ArrayList<T> arr, ArrayList<T> temp, int left, int right)
		// This tmp array needs to be same size as parameter array
		{

			if (left >= right) {
				return;
			} // end recurrsion
			if ((right - left)+1 < threshold) {
		//		 System.out.println("InsertionSort was called");
				insertionsort(arr, left, right);
				return;
			}
			int mid = (left + right) / 2;
			mergesort(arr, temp, left, mid);
			mergesort(arr, temp, mid + 1, right);
			merge(arr, temp, left, right);
		}

		/**
		 * Internal method for merging two sorted subarrays
		 * 
		 * @param arr
		 *            - input ArrayList of objects
		 * @param temp
		 *            - temporary ArrayList in which the result with be placed
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 */
		private static <T extends Comparable<? super T>> void merge(
				ArrayList<T> arr, ArrayList<T> temp, int left, int right) {

			int rightPos = ((left + right) / 2) + 1;
			int leftEnd = rightPos - 1;
			int tmpPos = left;
			int numElements = right - left + 1;

			// Main loop
			while (left <= leftEnd && rightPos <= right)
				if (arr.get(left).compareTo(arr.get(rightPos)) <= 0)
					temp.set(tmpPos++, arr.get(left++));

				else
					temp.set(tmpPos++, arr.get(rightPos++));

			while (left <= leftEnd)
				// copy rest of first ahlf
				temp.set(tmpPos++, arr.get(left++));

			while (rightPos <= right)
				// copy rest of right half
				temp.set(tmpPos++, arr.get(rightPos++));

			// Copy tmpArray
			for (int i = 0; i < numElements; i++, right--)
				arr.set(right, temp.get(right));
		}

		/**
		 * Quicksort algorithm driver
		 * 
		 * @param arr
		 *            - input ArrayList of objects
		 */
		public static <T extends Comparable<? super T>> void quicksort(
				ArrayList<T> arr) {
			// call insertion sort if threshold is met?
			// if (arr.size() <= 0) {
			// throw new IndexOutOfBoundsException();
			// }
			quicksort(arr, 0, arr.size() - 1);
		}

		public static <T extends Comparable<? super T>> void swapReferences(
				ArrayList<T> array, int right, int left) {
			T temp = array.get(right);
			array.set(right, array.get(left));
			array.set(left, temp);
		}

		/**
		 * Main quicksort method. Makes recursive calls.
		 * 
		 * @param arr
		 *            - input ArrayList of objects.
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 */
		public static <T extends Comparable<? super T>> void quicksort(
				ArrayList<T> arr, int left, int right) {

			// must be placed in the recursive quicksort method, at the very
			// beginning (arr[], int left, int right)
			// is the parameter array null or have only 1 value or less?
			if (arr == null || arr.size() <= 0)
				return;
			// what is the threshold?
			// call insertion sort if the list is small
//			if (arr.size() < threshold) {
//				// System.out.println("InsertionSort was called");
//				insertionsort(arr, 0, arr.size());
//				return;
//			}

			int i = left; // index i
			int j = right; // index j

			T pivot; // find pivot using one of the three strategies
			//pivot = arr.get(pivotStrategy3(arr, left, right)); // firstElement

			// Working Code
			switch (pivotCase) {
			case 1:
				pivot = arr.get(pivotStrategy1(arr, left, right)); // get middle
																	// element
				break;
			case 2:
				pivot = arr.get(pivotStrategy2(arr, left, right)); 
				// get sample of middle of 3, and swap them in place
										
				break;
			default:
				pivot = arr.get(pivotStrategy3(arr, left, right)); // firstElement
				break;
			}

			while (i <= j) { // stop this loop once the indeces cross each other
				while (arr.get(i).compareTo(pivot) < 0)
					// put every element greater than the pivot to the right of
					// it
					i++;
				while (arr.get(j).compareTo(pivot) > 0)
					// put every element smaller than the pivot to the left of
					// it
					j--;
				if (i <= j) {
					if (i < j)
						swapReferences(arr, i, j); // swap i for j if i is less
													// than j
					i++;
					j--;
				}
			}
			// split the array into right and left and quicksort it recursively
			if (i < right)
				quicksort(arr, i, right);
			if (j > left)
				quicksort(arr, left, j);
		}

		/**
		 * First pivot strategy
		 * 
		 * @param arr
		 *            - input ArrayList of objects.
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 * @return index of chosen pivot
		 */
		public static <T extends Comparable<? super T>> int pivotStrategy1(
				ArrayList<T> arr, int left, int right) {
			// according to the book, this is not an excellent strategy, but it
			// isn't bad either. We will always
			// avoid getting a worst case scenario that comes by picking the
			// first
			// element in the array
			return (left + right) / 2;
		}

		/**
		 * Second pivot strategy
		 * 
		 * @param arr
		 *            - input ArrayList of objects.
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 * @return index of chosen pivot
		 */
		public static <T extends Comparable<? super T>> int pivotStrategy2(
				ArrayList<T> arr, int left, int right) {
			{
				// median of 3 partitioning; we are sampling the array for good
				// values
				return (((left + right) / 2)/* the mid */+ left + right) / 3;
			}
		}

		/**
		 * Third pivot strategy
		 * 
		 * @param arr
		 *            - input ArrayList of objects.
		 * @param left
		 *            - start of the subarray
		 * @param right
		 *            - end of the subarray
		 * @return index of chosen pivot
		 */
		public static <T extends Comparable<? super T>> int pivotStrategy3(
				ArrayList<T> arr, int left, int right) {
			// We could just do first element of array strategy, or random
			// partition
			// of 3, or swapping algorithm:
			return left;
		}

		/**
		 * Generates the BestCase (ascending sorted ArrayList) for input into
		 * sorting algorithms.
		 * 
		 * @param size
		 *            size of the returned ArrayList
		 * @return an ArrayList of integers in sorted, ascending order.
		 */
		public static ArrayList<Integer> generateBestCase(int size) {
			ArrayList<Integer> temp = new ArrayList<Integer>();

			for (int i = 0; i < size; i++) {
				temp.add(i);
			}
			return temp;
		}

		/**
		 * Generates the AverageCase (permuted ArrayList) for input into sorting
		 * algorithms.
		 * 
		 * @param size
		 *            the size of the returned ArrayList
		 * @return An ArrayList of random integers from 0-size in permuted order
		 */
		/**
		 * Generates the AverageCase (permuted ArrayList) for input into sorting
		 * algorithms.
		 * 
		 * @param size
		 *            the size of the returned ArrayList
		 * @return An ArrayList of random integers from 0-size in permuted order
		 */
		public static ArrayList<Integer> generateAverageCase(int size) {
			ArrayList<Integer> temp = new ArrayList<Integer>(size);
			// temp=generateAverageCase(size);
			Random rnd = new Random();
			for (int i = 0; i < size; i++) {
				temp.add(i);
			}
			for (int i = 0; i < temp.size(); i++) {
				int a = temp.get(i);
				int index = rnd.nextInt(temp.size());
				temp.set(i, temp.get(index));
				temp.set(index, a);

			}
			return temp;
		}

		/**
		 * Generates a WorstCase (descending sorted ArrayList) for input into
		 * sorting algorithms.
		 * 
		 * @param size
		 *            the size of the returned ArrayList
		 * @return An ArrayList of integers in descending order
		 */
		public static ArrayList<Integer> generateWorstCase(int size) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = size; i > 0; i--)// test this i>=?
			{
				temp.add(i);
			}
			return temp;
		}

	}
