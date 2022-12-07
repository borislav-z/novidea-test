import custom.data.structure.QuickPopOrderedList;
import custom.data.structure.QuickPushOrderedList;

import javax.management.OperationsException;
import java.util.Random;

/**
 * @author ${Lyubomir Tsvetkov}
 *
 *
 */

public class Main {

    public static void main(String[] args) throws OperationsException
    {
        QuickPopOrderedList numListPop = new QuickPopOrderedList();
        QuickPushOrderedList numListPush = new QuickPushOrderedList();

//        numListPop.push(1);
//        numListPop.push(4);
//        numListPop.push(2);
//        numListPop.push(7);
//        numListPop.pop();
//        numListPop.print();

//-----------------------------------------------------------------------------------------------
//        numListPush.push(1);
//        numListPush.push(4);
//        numListPush.push(2);
//        numListPush.pop();
//        numListPush.print();



        Random random = new Random();
        for(int i= 0;i <= 10000;i++){
            int randomIntCap = random.nextInt(1000);
            numListPop.push(randomIntCap);
        }


    }
}

