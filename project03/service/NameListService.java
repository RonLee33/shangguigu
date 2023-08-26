package project03.service;

import project03.domain.Architect;
import project03.domain.Designer;
import project03.domain.Employee;
import project03.domain.NoteBook;
import project03.domain.PC;
import project03.domain.Printer;
import project03.domain.Programmer;
import project03.view.Data;

public class NameListService {
    public static void main(String[] args) {
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        try {
            System.out.println("id为3的员工为：" + nameListService.getEmployee(3));
            System.out.println("id为13的员工为：" + nameListService.getEmployee(13));
        } catch (TeamException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
    }

    private Employee[] employees = new Employee[Data.EMPLOYEES.length];

    public NameListService(){
        
        getEmployeeInfoList();
        
        allowEquipment();
    }

    private void getEmployeeInfoList(){
        for(int i = 0; i < Data.EMPLOYEES.length; i++){
            String[] employeePro = Data.EMPLOYEES[i];
            switch (Integer.parseInt(employeePro[0])) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(Integer.parseInt(employeePro[1]), 
                                                employeePro[2], 
                                                Integer.parseInt(employeePro[3]), 
                                                Double.parseDouble(employeePro[4]));
                    break;
                case Data.PROGRAMMER:
                    employees[i] = new Programmer(Integer.parseInt(employeePro[1]), 
                                                employeePro[2], 
                                                Integer.parseInt(employeePro[3]), 
                                                Double.parseDouble(employeePro[4]), 
                                                null);//new 
                    break;
                case Data.DESIGNER:
                    employees[i] = new Designer(Integer.parseInt(employeePro[1]), 
                                                employeePro[2], 
                                                Integer.parseInt(employeePro[3]), 
                                                Double.parseDouble(employeePro[4]),
                                                null,
                                                Double.parseDouble(employeePro[5])
                                                );
                    break;
                case Data.ARCHITECT:
                    employees[i] = new Architect(Integer.parseInt(employeePro[1]), 
                                                employeePro[2], 
                                                Integer.parseInt(employeePro[3]), 
                                                Double.parseDouble(employeePro[4]),
                                                null,
                                                Double.parseDouble(employeePro[5]),
                                                Integer.parseInt(employeePro[6])
                                                );
                    break;                    
                default:
                    break;
            }
        }
    }

    private void allowEquipment(){
        Programmer programmer;
        for (int i = 0; i < Data.EQUIPMENTS.length; i++){
            String[] equipmentPro = Data.EQUIPMENTS[i];
            if (equipmentPro.length == 0) {
                continue;
            }

            programmer = (Programmer) employees[i];
            switch (Integer.parseInt(equipmentPro[0])) {
                case Data.PC:
                    programmer.setEquipment(new PC(equipmentPro[1], equipmentPro[2]));
                    break;
                case Data.NOTEBOOK:
                    programmer.setEquipment(new NoteBook(equipmentPro[1], Double.parseDouble(equipmentPro[2])));
                    break;
                case Data.PRINTER:
                    programmer.setEquipment(new Printer(equipmentPro[1], equipmentPro[2]));
                default:
                    break;
            }
            
            employees[i] = programmer;
            
        }
    }

    public Employee[] getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException{
        // 找不到指定id员工时抛出异常
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getId() == id){
                return  employees[i];
            }
        }
        throw new TeamException("找不到id=" + id + "的员工");
    }

}
