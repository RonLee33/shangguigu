package project03.service;

import project03.domain.Architect;
import project03.domain.Designer;
import project03.domain.Employee;
import project03.domain.Programmer;
import project03.view.Data;

public class TeamService {
    private int count = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    public TeamService(){

    }

    public Programmer[] getTeam(){
        return team;
    }

    public void addMember(Employee employee) throws TeamException{
        if (total == MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }else if (total > -1 && total < MAX_MEMBER){
            if (employee instanceof Programmer){

                Programmer tmp = (Programmer)employee;
                
                int[] developersNumber = getDevelopersNumber();
                if (tmp.getStatus() == Status.BUSY){
                    // 1.该成员已是某团队成员
                    throw new TeamException("该成员已是某团队成员");
                } else if (tmp.getStatus() == Status.VOCATION){
                    // 2.该成员正在休假，无法添加
                    throw new TeamException("该成员正在休假，无法添加");
                } else if (isInTeamById(employee.getId())){
                    // 3.该成员已在本开发团队中
                    throw new TeamException("该成员已在本开发团队中");
                } else if (developersNumber[2] > 1 && tmp instanceof Architect) {
                    // 4.团队中至多只能有一名架构师
                    throw new TeamException("团队中至多只能有一名架构师");
                } else if (developersNumber[1] > 2 && tmp instanceof Designer) {
                    // 5.团队中至多只能有两名设计师
                    throw new TeamException("团队中至多只能有两名设计师");
                } else if (developersNumber[0] > 3) {
                    // 6.团队中至多只能有三名程序员
                    throw new TeamException("团队中至多只能有三名程序员");
                } else {
                    // 可以成功添加的
                    //这里要设置成已有成员中memberID的最大值加一，找最大值的逻辑后面再补
                    tmp.setMemberId(count++);
                    tmp.setStatus(Status.BUSY);
                    team[total++] = tmp;
                }

            } else{
                throw new TeamException("该成员不是开发人员，无法添加");
            }
        }
        throw new TeamException("添加失败的其他原因");
    }

    private int[] getDevelopersNumber(){
        //统计团队中不同开发人员数量
        int[] nums = new int[]{0, 0, 0}; // 程序员、设计师、架构师数量
        for (Programmer programmer : team) {
            if (programmer instanceof Architect){
                nums[Data.ARCHITECT - Data.PROGRAMMER] += 1; // 统计架构师数量
            } else if (programmer instanceof Designer) {
                nums[Data.DESIGNER - Data.PROGRAMMER] += 1; // 统计设计师数量
            } else {
                nums[Data.PROGRAMMER - Data.PROGRAMMER] += 1; // 统计程序员数量
            }
        }
        return nums;
    }

    private boolean isInTeamById(int employeeId){
        // 通过employeeId判断某员工是否已在团队中
        for (int i = 0; i < total; i++){
            if (employeeId == team[i].getId()){
                return true;
            }
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException{
        for (int i = 0; i < total; i++){
            if (team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                total -= 1;
                team[i] = null;
                for (int j = i; j < total - 1; j++){
                    team[j] = team[j + 1];
                }
            }
        }
        throw new TeamException("找不到指定memberId=" + memberId +"的员工");
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMAX_MEMBER() {
        return MAX_MEMBER;
    }

    public void setTeam(Programmer[] team) {
        this.team = team;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
