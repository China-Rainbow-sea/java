package day18.com.RainbowSea.team.service;


import day18.com.RainbowSea.team.domain.Employee;
import org.junit.Test;

/**
 * 对NameListService类的测试
 */
public class NameListServiceTest {

    /**
     * 对于 GetAllEmployees() 方法的测试
     */
    @Test
    public void testGetAllEmployees() {
        NameListService nameListService = new NameListService();
        Employee[] allEmployee = nameListService.getAllEmployee();

        for (Employee e : allEmployee) {
            System.out.println(e);
        }

    }


    /**
     * 对于 GetEmployee() 方法的测试
     */
    @Test
    public void testGetEmployee() {
        NameListService nameListService = new NameListService();
        int id = 1;
        try {
            Employee employee = nameListService.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());  // 获取异常的对象值
        }
    }
}
