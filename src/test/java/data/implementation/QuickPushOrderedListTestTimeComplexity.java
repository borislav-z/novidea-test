package data.implementation;

import data.contracts.LinkedItemList;

import javax.management.OperationsException;

public class QuickPushOrderedListTestTimeComplexity {

    /**
     * Class that is trying to measure the time it takes to push 100, 1000, 10000 elements. For effective push() method a
     * relatively stable average time per operation is needed
     */
    public static void main(String[] args) throws OperationsException {
        popTestTimeComplexity();
    }

    static void popTestTimeComplexity() throws OperationsException {
        testForNumberOfOps(10000);
        testForNumberOfOps(1000);
        testForNumberOfOps(100);
        testForNumberOfOps(10);
    }

    static long populateListAndReturnTime(LinkedItemList list, int num) {
        var startTime = System.nanoTime();
        for (int i = 0; i <= num; i++) {
            list.push(i);
        }
        var stopTime = System.nanoTime();
        return stopTime - startTime;
    }

    static void testForNumberOfOps(int numberOfOps) {
        System.out.println(numberOfOps + " item test");
        System.out.println("-------------");

        var qPushList = new QuickPushOrderedList<Integer>();
        var totalTime = populateListAndReturnTime(qPushList, numberOfOps);
        float avg = totalTime / numberOfOps;

        System.out.println(" - Total time: " + totalTime);
        System.out.println(" - Avg. time per operation: " + avg);
        System.out.println("-----------------------------------------------------");
    }

}