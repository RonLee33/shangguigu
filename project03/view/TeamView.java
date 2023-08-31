package project03.view;


import project03.domain.Architect;
import project03.domain.Designer;
import project03.domain.Employee;
import project03.domain.Programmer;
import project03.service.NameListService;
import project03.service.TeamException;
import project03.service.TeamService;

public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public static void main(String[] args) throws TeamException{
        TeamView tv = new TeamView();
        tv.enterMainMenu();
    }

    public void enterMainMenu(){
        char selection = '0';
        while (selection != '4') {
            listAllEmployees();
            System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)");
            selection = TSUtility.readMenuSelection();
            switch (selection) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;             
                default:
                    break;
            }
            TSUtility.readReturn();
        }
    }

    private void listAllEmployees(){
        // 列出公司所有员工
        System.out.println("----------------开发团队调度系统----------------");
        System.out.println("ID  \t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
        Employee[] employees = listSvc.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("---------------------------------------------");
    }

    private void getTeam(){
        // 显示团队成员
        System.out.println("----------------团队成员列表-----------------");
        System.out.println("TDI/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
        Programmer[] programmers = teamSvc.getTeam();
        for (Programmer programmer : programmers) {
            if (programmer == null) {
                // 增加判空处理
            } else if (programmer instanceof Architect) {
                System.out.println(programmer.getMemberId() + "/" + programmer.getEmployeeInfo() + "\t架构师\t" + ((Architect)programmer).getBonus() + "\t" + ((Architect)programmer).getStock());
            } else if(programmer instanceof Designer){
                System.out.println(programmer.getMemberId() + "/" + programmer.getEmployeeInfo() + "\t设计师\t" + ((Designer)programmer).getBonus());
            } else {
                System.out.println(programmer.getMemberId() + "/" + programmer.getEmployeeInfo() + "\t程序员\t");
            }
        }
        System.out.println("--------------------------------------------");

    }

    private void addMember(){
        // 实现添加成员操作
        System.out.println("-----------------添加成员------------------");
        System.out.print("请输入要添加的员工ID:");
        int employeeId = TSUtility.readInt();
        try {
            Employee e = listSvc.getEmployee(employeeId);
            teamSvc.addMember(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            // e.printStackTrace();
            System.out.println("添加失败，原因：" + e.getMessage());
        }

    }

    private void deleteMember(){
        // 实现删除成员操作
        System.out.println("-----------------删除成员------------------");
        System.out.print("请输入要删除员工的TID:");
        int tId = TSUtility.readInt();
        System.out.print("确认是否删除(Y/N)");
        String selection = TSUtility.readConfirmSelection() + "";
        if (selection.toUpperCase().equals("Y")){
            try {
                teamSvc.removeMember(tId);
                System.out.println("删除成功");
            } catch (TeamException e) {
                System.out.println("删除失败，原因：" + e.getMessage());
            }
        } else {
            return;
        }
    }
}
