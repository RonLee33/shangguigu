package project03.view;

import project03.domain.Employee;
import project03.domain.Programmer;
import project03.service.NameListService;
import project03.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) {
        TeamView tv = new TeamView();
        tv.listAllEmployees();
        
    }

    public void enterMainMenu(){

    }

    private void listAllEmployees(){
        // 列出公司所有员工
        System.out.println("----------------开发团队调度系统----------------");
        System.out.println("ID  \t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        Employee[] employees = listSvc.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("----------------开发团队调度系统----------------");
    }

    private void getTeam(){
        // 显示团队成员
        System.out.println("----------------团队成员列表----------------");
        System.out.println("TDI/ID  \t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        Programmer[] programmers = teamSvc.getTeam();
        for (Programmer programmer : programmers) {
            System.out.println(programmer);
        }
        System.out.println("----------------开发团队调度系统----------------");

    }

    private void addMember(){

    }

    private void deleteMember(){

    }
}
