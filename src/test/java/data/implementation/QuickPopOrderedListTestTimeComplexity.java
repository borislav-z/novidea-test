package data.implementation;

import data.contracts.LinkedItemList;

import javax.management.OperationsException;

public class QuickPopOrderedListTestTimeComplexity
{
    // Class that is trying to measure the time it takes to pop 10k elements
    // Unfortunately, without using 3rt party libraries such as JUnitPerf or Google Caliper for micro-benchmark tests it is not consistent or reliable

    public static void main(String[] args) throws OperationsException
    {
        popTestTimeComplexity();
    }
    static void popTestTimeComplexity() throws OperationsException
    {
        var qPopList = new QuickPopOrderedList();
        generateTestData(qPopList);
        long startTime = System.nanoTime();
        for (int i = 0;i < 10000;i++)
        {
            qPopList.pop();
        }
        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime));
    }

   static void generateTestData(LinkedItemList list)
   {
        for(int i= 0;i <= 10000;i++){
            list.push(i);
        }
    }
}
