import data.contracts.ILinkedItemList;
import data.implementation.QuickPopOrderedList;
import data.implementation.QuickPushOrderedList;
import data.implementation.ReversedIntegerComparator;
import extra.models.Employee;
import extra.models.PaidEmployee;

import javax.management.OperationsException;

public class Main {

    public static void main(String[] args) {
        /*testIntegers();
        testStrings();
        testIntegersReversedOrder();
        testEmployees();
        testPaidEmployees();*/

        testThreadSafeQuickPop();
        testThreadSafeQuickPush();
    }

    public static void testThreadSafeQuickPop() {
        var qPopList = new QuickPopOrderedList<Integer>();

        for (int x = 1; x < 60; x++) {
            new Thread(() -> {
                var rand = generate(1, 1000);
                qPopList.push(rand);
                System.out.printf("The output of the push thread is : %s - %d%n", Thread.currentThread().getName(), rand);
            }).start();

            if(x % 2 == 0) {
                new Thread(() -> {
                    var result = qPopList.pop();
                    System.out.printf("The output of the pop thread is : %s - %d%n", Thread.currentThread().getName(), result.getValue());
                }).start();
            }
        }

        System.out.println("---------------------");
        System.out.println("Quick Pop Integer List");
        System.out.println("---------------------");
        printList(qPopList);
    }

    public static void testThreadSafeQuickPush() {
        var qPushList = new QuickPushOrderedList<Integer>();

        for (int x = 1; x < 60; x++) {
            new Thread(() -> {
                var rand = generate(1, 1000);
                qPushList.push(rand);
                System.out.printf("The output of the push thread is : %s - %d%n", Thread.currentThread().getName(), rand);
            }).start();

            if(x % 2 == 0) {
                new Thread(() -> {
                    var result = qPushList.pop();
                    System.out.printf("The output of the pop thread is : %s - %d%n", Thread.currentThread().getName(), result.getValue());
                }).start();
            }
        }

        System.out.println("---------------------");
        System.out.println("Quick Push Integer List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    private static int generate(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

    public static void testEmployees() {
        var qPopList = new QuickPopOrderedList();
        var qPushList = new QuickPushOrderedList();
        var data = new Employee[]{
                new Employee(1, "Ann"),
                new Employee(2, "George"),
                new Employee(3, "Daniel"),
                new Employee(4, "Carla"),
                new Employee(5, null)
        };
        for (Employee d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }
        System.out.println("---------------------");
        System.out.println("Quick Pop Employee List");
        System.out.println("---------------------");
        printList(qPopList);

        System.out.println("Quick Push Employee List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    public static void testPaidEmployees() {
        var qPopList = new QuickPopOrderedList();
        var qPushList = new QuickPushOrderedList();
        var data = new PaidEmployee[]{
                new PaidEmployee(1, "Ann", 1500),
                new PaidEmployee(2, "George", 1000),
                new PaidEmployee(3, "Daniel", 1200),
                new PaidEmployee(4, "Carla", 2000),
                new PaidEmployee(5, null, 0)
        };
        for (PaidEmployee d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }
        System.out.println("---------------------");
        System.out.println("Quick Pop Paid Employee List");
        System.out.println("---------------------");
        printList(qPopList);

        System.out.println("Quick Push Paid Employee List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    public static void testIntegers() {
        var qPopList = new QuickPopOrderedList();
        var qPushList = new QuickPushOrderedList();
        var data = new int[]{1, 4, 2, 7};
        for (int d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }
        System.out.println("---------------------");
        System.out.println("Quick Pop Integer List");
        System.out.println("---------------------");
        printList(qPopList);

        System.out.println("Quick Push Integer List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    public static void testIntegersReversedOrder() {
        var qPopList = new QuickPopOrderedList();
        qPopList.setComparator(new ReversedIntegerComparator());
        var qPushList = new QuickPushOrderedList();
        qPushList.setComparator(new ReversedIntegerComparator());

        var data = new int[]{1, 4, 2, 7};
        for (int d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }
        System.out.println("---------------------");
        System.out.println("Quick Pop Reversed Integer List");
        System.out.println("---------------------");
        printList(qPopList);

        System.out.println("Quick Push Reversed Integer List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    public static void testStrings() {
        var qPopList = new QuickPopOrderedList();
        var qPushList = new QuickPushOrderedList();
        var data = new String[]{"A", "D", "B", "F"};
        for (String d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }
        System.out.println("---------------------");
        System.out.println("Quick Pop String List");
        System.out.println("---------------------");
        printList(qPopList);

        System.out.println("Quick Push String List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    private static void printList(ILinkedItemList list) {
        System.out.println(" - Linked list inner order");
        System.out.println("---------------------");
        list.display();

        System.out.println("---------------------");
        System.out.println(" - Linked list popping order");
        System.out.println("---------------------");
        while (!list.isEmpty()) {
            var item = list.pop();
            item.display();
        }
    }
}

