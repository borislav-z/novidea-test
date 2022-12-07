package custom.data.structure;

import javax.management.OperationsException;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */

public class QuickPushOrderedListTestTimeComplexity {

    static QuickPushOrderedList numListPush = new QuickPushOrderedList();

    // Class that is trying to measure the time it takes to push 10k elements
    // Unfortunately, without using 3rt party libraries such as JUnitPerf or Google Caliper for micro-benchmark tests it is not consistent or reliable

    public static void main(String[] args) throws OperationsException
    {
        popTestTimeComplexity();
    }
    static void popTestTimeComplexity() throws OperationsException
    {
        long startTime = System.nanoTime();
        for (int i = 0;i < 10000;i++)
        {
            numListPush.push(i);
        }
        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime));
    }

}