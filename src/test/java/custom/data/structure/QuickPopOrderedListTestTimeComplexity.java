package custom.data.structure;

import javax.management.OperationsException;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */

public class QuickPopOrderedListTestTimeComplexity
{

    static QuickPopOrderedList numListPop = new QuickPopOrderedList();

    // Class that is trying to measure the time it takes to pop 10k elements
    // Unfortunately, without using 3rt party libraries such as JUnitPerf or Google Caliper for micro-benchmark tests it is not consistent or reliable

    public static void main(String[] args) throws OperationsException
    {
        popTestTimeComplexity();
    }
    static void popTestTimeComplexity() throws OperationsException
    {
        generateTestData();
        long startTime = System.nanoTime();
        for (int i = 0;i < 10000;i++)
        {
            numListPop.pop();
        }
        long stopTime = System.nanoTime();
        System.out.println((stopTime - startTime));
    }

   static void generateTestData()
   {
        for(int i= 0;i <= 10000;i++){
            numListPop.push(i);
        }
    }
}
