package data.implementation;

import data.exceptions.EmptyListException;
import extra.models.Employee;
import extra.models.PaidEmployee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderedEmployeeListsTest {

    @Test
    void testEmployees_PopulatedList_ShouldReturnThemInNameDescendingOrder() {
        var qPopList = new QuickPopOrderedList<Employee>();
        var qPushList = new QuickPushOrderedList<Employee>();

        var data = new Employee[]{
                new Employee(1, "Ann"),
                new Employee(2, "George"),
                new Employee(3, "Daniel"),
                new Employee(4, "Carla")
        };
        for (Employee d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }

        assertEquals("George", qPopList.pop().getValue().getName());
        assertEquals("Daniel", qPopList.pop().getValue().getName());
        assertEquals("Carla", qPopList.pop().getValue().getName());
        assertEquals("Ann", qPopList.pop().getValue().getName());

        assertEquals("George", qPushList.pop().getValue().getName());
        assertEquals("Daniel", qPushList.pop().getValue().getName());
        assertEquals("Carla", qPushList.pop().getValue().getName());
        assertEquals("Ann", qPushList.pop().getValue().getName());
    }

    @Test
    void testPopPaidEmployee_PopulatedList_ShouldReturnThemInSalaryAscendingOrder() {
        var qPopList = new QuickPopOrderedList<Employee>();
        var qPushList = new QuickPopOrderedList<Employee>();

        var data = new PaidEmployee[]{
                new PaidEmployee(1, "Ann", 1500),
                new PaidEmployee(2, "George", 1000),
                new PaidEmployee(3, "Daniel", 1200),
                new PaidEmployee(4, "Carla", 2000)
        };
        for (PaidEmployee d : data) {
            qPopList.push(d);
            qPushList.push(d);
        }
        var employee = ((PaidEmployee)qPopList.pop().getValue());
        assertEquals("George", employee.getName());
        assertEquals(1000, employee.getSalary());

        employee = ((PaidEmployee)qPopList.pop().getValue());
        assertEquals("Daniel", employee.getName());
        assertEquals(1200, employee.getSalary());

        employee = ((PaidEmployee)qPopList.pop().getValue());
        assertEquals("Ann", employee.getName());
        assertEquals(1500, employee.getSalary());

        employee = ((PaidEmployee)qPopList.pop().getValue());
        assertEquals("Carla", employee.getName());
        assertEquals(2000, employee.getSalary());

        //==== quick push list

        employee = ((PaidEmployee)qPushList.pop().getValue());
        assertEquals("George", employee.getName());
        assertEquals(1000, employee.getSalary());

        employee = ((PaidEmployee)qPushList.pop().getValue());
        assertEquals("Daniel", employee.getName());
        assertEquals(1200, employee.getSalary());

        employee = ((PaidEmployee)qPushList.pop().getValue());
        assertEquals("Ann", employee.getName());
        assertEquals(1500, employee.getSalary());

        employee = ((PaidEmployee)qPushList.pop().getValue());
        assertEquals("Carla", employee.getName());
        assertEquals(2000, employee.getSalary());
    }

    @Test
    void testPopStrings_EmptyList_ShouldFailWithEmptyListException() {
        var qPopList = new QuickPopOrderedList<Employee>();
        assertThatThrownBy(qPopList::pop)
                .isInstanceOf(EmptyListException.class);
    }

    //Ensure we have the expected size of the data structure
    @Test
    void testPushEmployees_PopulatedList_ShouldReturnValidSize() {
        var qPopList = new QuickPopOrderedList<Employee>();
        var data = new Employee[]{
                new PaidEmployee(1, "Ann", 1500),
                new PaidEmployee(2, "George", 1000),
                new PaidEmployee(3, "Daniel", 1200),
                new PaidEmployee(4, "Carla", 2000)
        };
        for (Employee d : data) {
            qPopList.push(d);
        }

        assertEquals(4, qPopList.getSize());
    }

    @Test
    void testIsEmptyListStrings_EmptyList_ShouldReturnTrue() {
        var qPopList = new QuickPopOrderedList<String>();
        assertTrue(qPopList.isEmpty());
    }
}