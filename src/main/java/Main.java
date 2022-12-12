import data.contracts.ILinkedItemList;
import data.implementation.QuickPopOrderedList;
import data.implementation.QuickPushOrderedList;
import data.implementation.ReversedIntegerComparator;
import extra.models.Employee;
import extra.models.PaidEmployee;

import javax.management.OperationsException;

public class Main {

    public static void main(String[] args) throws OperationsException {
        testIntegers();
        testStrings();
        testIntegersReversedOrder();
        testEmployees();
        testPaidEmployees();
    }

    public static void testEmployees() throws OperationsException {
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

    public static void testPaidEmployees() throws OperationsException {
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

    public static void testIntegers() throws OperationsException {
        var qPopList = new QuickPopOrderedList();
        var qPushList = new QuickPushOrderedList();
        var data = new int[]{1, 4, 2, 7};
        for (int d : data) {
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

    public static void testIntegersReversedOrder() throws OperationsException {
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
        System.out.println("Quick Pop Reverse Integer List");
        System.out.println("---------------------");
        printList(qPopList);

        System.out.println("Quick Push Reversed Integer List");
        System.out.println("---------------------");
        printList(qPushList);
    }

    public static void testStrings() throws OperationsException {
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

    private static void printList(ILinkedItemList list) throws OperationsException {
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

