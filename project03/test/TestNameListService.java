package project03.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import project03.domain.Employee;
import project03.service.NameListService;
import project03.service.TeamException;

public class TestNameListService {
    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        int len = 12;
        int count = 0;
        for (Employee employee : employees) {
            System.out.println(employee);
            count += 1;
        }
        assertEquals(len, count);
    }

    @Test
    public void testGetEmployeeSuccess(){
        // 测试找到员工时
        Boolean isFound = false;
        NameListService nameListService = new NameListService();
        try {
            System.out.println("id为3的员工为：" + nameListService.getEmployee(3));
            isFound = true;
        } catch (TeamException e) {
            e.printStackTrace();
            isFound = false;
        } finally {
            assertEquals(true, isFound);
        }
    }


    @Test
    public void testGetEmployeeFailure(){
        // 测试找不到员工时
        Boolean isFound = false;
        NameListService nameListService = new NameListService();
        try {
            System.out.println("id为13的员工为：" + nameListService.getEmployee(13));
            isFound = true;
        } catch (TeamException e) {
            e.printStackTrace();
            isFound = false;
        } finally {
            assertEquals(false, isFound);
        }
    }

}
