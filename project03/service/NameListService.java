package project03.service;

import project03.domain.Employee;
import project03.view.Data;

public class NameListService {
    public static void main(String[] args) {
        
    }

    private Employee[] employees;

    public NameListService(){
        for(int i = 0; i < Data.EMPLOYEES.length; i++){
            String[] employeePro = Data.EMPLOYEES[i];
            switch (Integer.parseInt(employeePro[0])) {
                case Data.EMPLOYEE:
                    employees[0] = new Employee(Integer.parseInt(employeePro[1]), 
                                                employeePro[2], 
                                                Integer.parseInt(employeePro[3]), 
                                                Double.parseDouble(employeePro[4]));
                    break;
                default:
                    break;
            }
        }
    }



}
