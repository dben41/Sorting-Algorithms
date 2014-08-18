package assignment4;

import java.util.ArrayList;

public class TestSortUtil {
 

/**
* This main purpose of this class is to make sure that the methods are functional
* we will test how the arrays sort arrays using the 3 array generators, empty arrays.
* The tests will always be in sets of 2, the undordered array followed by the ordered array. (At least it should be in order!)
* 
*  :/ note :/ my machine seems to cut off the print statement for some reason. To see all output, one simply need to comment out chunks at a time.
*  
*  @ author  Daryl Bennett && Leland Stenquist
*/
public static void main(String[] args) {
//MergeSort tests
System.out.println("MergeSort tests \n The first array is before sorting, and the second is after sorting: \n -----------------------------------------------");
//worst case tests
ArrayList<Integer> worstCasesZero=SortUtil.generateWorstCase(0);    //empty array
ArrayList<Integer> worstCasesmall=SortUtil.generateWorstCase(1);    //array of 1
ArrayList<Integer> worstCaseNormal=SortUtil.generateWorstCase(100);  //normal size array
ArrayList<Integer> worstCaseLarge=SortUtil.generateWorstCase(2500); //large array
////avg case tests
ArrayList<Integer> avgCasesmall=SortUtil.generateAverageCase(1);    //array of 1
ArrayList<Integer> avgCaseNormal=SortUtil.generateAverageCase(100);  //normal size array
ArrayList<Integer> avgCaseLarge=SortUtil.generateAverageCase(2500); //large array
//best case       __best for last :)  
ArrayList<Integer> bestCasesmall=SortUtil.generateBestCase(1);    //array of 1
ArrayList<Integer> bestCaseNormal=SortUtil.generateBestCase(100);  //normal size array
ArrayList<Integer> bestCaseLarge=SortUtil.generateBestCase(2500); //large array
//worst cases
System.out.println("This tests an empty array: " +  worstCasesZero);
System.out.println("This tests a worstCase array of size one: " +  worstCasesmall);
SortUtil.mergesort(worstCasesmall);
System.out.println(worstCasesmall);
System.out.println("This tests a worstCase array (descending order) of size 100: " +  worstCaseNormal);
SortUtil.mergesort(worstCaseNormal);
System.out.println(worstCaseNormal);
System.out.println("This tests a worstCase array (descending order) of size 2500: " +  worstCaseLarge);
SortUtil.mergesort(worstCaseLarge);
System.out.println(worstCaseLarge);
//avg case (permuted
System.out.println("This tests a averageCase (permuted order) array of size one:  " +  avgCasesmall);
SortUtil.mergesort(avgCasesmall);
System.out.println(avgCasesmall);
System.out.println("This tests a averageCase array (permuted order) of size 100: " +  avgCaseNormal);
SortUtil.mergesort(avgCaseNormal);
System.out.println(avgCaseNormal);
System.out.println("This tests a averageCase array (permuted order) of size 2500: " +  avgCaseLarge);
SortUtil.mergesort(avgCaseLarge);
System.out.println(avgCaseLarge);
//best case (ascending)
System.out.println("This tests a bestCase (ascending order) array of size one:  " +  bestCasesmall);
SortUtil.mergesort(bestCasesmall);
System.out.println(bestCasesmall);
System.out.println("This tests a bestCase array (ascending order) of size 100: " +  bestCaseNormal);
SortUtil.mergesort(bestCaseNormal);
System.out.println(bestCaseNormal);
System.out.println("This tests a bestCase array (ascending order) of size 2500: " +  bestCaseLarge);
SortUtil.mergesort(bestCaseLarge);
System.out.println(bestCaseLarge);




//QuickSort tests
//worst case tests
ArrayList<Integer> worstCasesZero1=SortUtil.generateWorstCase(0);    //empty array
ArrayList<Integer> worstCasesmall1=SortUtil.generateWorstCase(1);    //array of 1
ArrayList<Integer> worstCaseNormal1=SortUtil.generateWorstCase(100);  //normal size array
ArrayList<Integer> worstCaseLarge1=SortUtil.generateWorstCase(2500); //large array
//avg case tests
ArrayList<Integer> avgCasesmall1=SortUtil.generateAverageCase(1);    //array of 1
ArrayList<Integer> avgCaseNormal1=SortUtil.generateAverageCase(100);  //normal size array
ArrayList<Integer> avgCaseLarge1=SortUtil.generateAverageCase(250); //large array
//best case       __best for last :)  
ArrayList<Integer> bestCasesmall1=SortUtil.generateBestCase(1);    //array of 1
ArrayList<Integer> bestCaseNormal1=SortUtil.generateBestCase(100);  //normal size array
ArrayList<Integer> bestCaseLarge1=SortUtil.generateBestCase(2500); //large array

///worst cases
System.out.println("quicksort---------------------------------- \n");
System.out.println("This tests an empty array: " +  worstCasesZero1);
SortUtil.quicksort(worstCasesZero1);
System.out.println(worstCasesZero1);
System.out.println("This tests a worstCase array of size one: " +  worstCasesmall1);
SortUtil.quicksort(worstCasesmall1);
System.out.println(worstCasesmall);
System.out.println("This tests a worstCase array (descending order) of size 100: " +  worstCaseNormal1);
SortUtil.quicksort(worstCaseNormal1);
System.out.println(worstCaseNormal1);
System.out.println("This tests a worstCase array (descending order) of size 2500: " +  worstCaseLarge1);
SortUtil.quicksort(worstCaseLarge1);
System.out.println(worstCaseLarge1);
//avg case (permuted
System.out.println("This tests a averageCase (permuted order) array of size one:  " +  avgCasesmall1);
SortUtil.quicksort(avgCasesmall1);
System.out.println(avgCasesmall1);
System.out.println("This tests a averageCase array (permuted order) of size 100: " +  avgCaseNormal1);
SortUtil.quicksort(avgCaseNormal1);
System.out.println(avgCaseNormal1);
System.out.println("This tests a averageCase array (permuted order) of size 2500: " +  avgCaseLarge1);
SortUtil.quicksort(avgCaseNormal1);
System.out.println(avgCaseNormal1);
//best case (ascending)
System.out.println("This tests a bestCase (ascending order) array of size one:  " +  bestCasesmall1);
SortUtil.quicksort(bestCasesmall1);
System.out.println(bestCasesmall1);
System.out.println("This tests a bestCase array (ascending order) of size 100: " +  bestCaseNormal1);
SortUtil.quicksort(bestCaseNormal1);
System.out.println(bestCaseNormal1);
System.out.println("This tests a bestCase array (ascending order) of size 2500: " +  bestCaseLarge1);
SortUtil.quicksort(bestCaseLarge1);
System.out.println(bestCaseLarge1);

//lets test the 3 pivot cases, and make sure they work
ArrayList<Integer> avgCasesmall2=SortUtil.generateAverageCase(10);    //array of 1
ArrayList<Integer> avgCaseNormal2=SortUtil.generateAverageCase(10);  //normal size array
ArrayList<Integer> avgCaseLarge2=SortUtil.generateAverageCase(10); //large array
ArrayList<Integer> something=SortUtil.generateAverageCase(10); //large array

System.out.println("");
System.out.println("Here is the test for 3 pivot cases of using quicksort. Displayed is the unsorted list and the sorted list. \n");

//1
System.out.println("PivotPoint 1: ");   //get middle element
System.out.println(avgCasesmall2);
SortUtil.pivotCase=1;
SortUtil.quicksort(avgCasesmall2);
System.out.println(avgCasesmall2);
//2
System.out.println("PivotPoint 2: ");   //get sample of middle of 3, and swap them in place
System.out.println(avgCaseNormal2);
SortUtil.pivotCase=2;
SortUtil.quicksort(avgCaseNormal2);
System.out.println(avgCaseNormal2);
//3
System.out.println("PivotPoint 3: ");    //firstElement
System.out.println(avgCaseLarge2);
SortUtil.pivotCase=3;
SortUtil.quicksort(avgCaseLarge2);
System.out.println(avgCaseLarge2);
//other than 4... (the default is pivotCase3)
System.out.println("PivotPoint 4 ( doesn't exist, but should work because of default case): ");
System.out.println(something);
SortUtil.pivotCase=3;
SortUtil.quicksort(something);
System.out.println(something);

SortUtil.pivotCase=3;
//array of same element
ArrayList<Integer> same=new ArrayList<Integer>(); //same array
for(int i = 0;i<20;i++)
same.add(7);
System.out.println("This tests an array of size 20 of same element using quicksort and mergesort: " +  same);
SortUtil.quicksort(same);
System.out.println("QuickSort: " + same);
SortUtil.mergesort(same);
System.out.println("MergeSort: " + same);
//superbig!
System.out.println("SUPER BIG ARRAYLIST, of 10,000 size");

ArrayList<Integer> superBig=SortUtil.generateAverageCase(10000);    //100,000 is the biggest integer that my computer can handle
System.out.println(superBig);
SortUtil.quicksort(superBig);
System.out.println("QuickSort: " + superBig);
ArrayList<Integer> superBig1=SortUtil.generateAverageCase(1000);    //10,00 is the biggest integer that my computer can handle
SortUtil.mergesort(superBig1);
System.out.println("MergeSort: " + superBig);
}
}
