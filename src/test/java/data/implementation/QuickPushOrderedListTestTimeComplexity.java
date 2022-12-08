package data.implementation;

import data.contracts.LinkedItemList;

import javax.management.OperationsException;

public class QuickPushOrderedListTestTimeComplexity {

    /**
     * Class that is trying to measure the time it takes to push 100, 1000, 10000 elements. For effective push() method a
     * relatively stable average time per operation is needed
     */
    public static void main(String[] args) throws OperationsException
    {
        popTestTimeComplexity();
    }
    static void popTestTimeComplexity() throws OperationsException
    {
        testForNumberOfOps(10);
        testForNumberOfOps(100);
        testForNumberOfOps(1000);
        testForNumberOfOps(10000);
    }

    static void generateTestData(LinkedItemList list, int num)
    {
        for(int i= 0;i <= num;i++){
            list.push(i);
        }
    }

    static long emptyListAndReturnTime(LinkedItemList list) {
        long startTime = System.nanoTime();
        while(!list.isEmpty()){
            list.pop();
        }
        long stopTime = System.nanoTime();
        return stopTime - startTime;
    }

    static void testForNumberOfOps(int numberOfOps){
        System.out.println(numberOfOps + " item test");
        System.out.println("-------------");

        var qPopList = new QuickPushOrderedList<Integer>();
        generateTestData(qPopList, numberOfOps);
        var totalTime = emptyListAndReturnTime(qPopList);

        System.out.println(" - Total time: " + totalTime);
        System.out.println(" - Avg. time per operation: " + totalTime/numberOfOps);
        System.out.println("-----------------------------------------------------");
    }

}