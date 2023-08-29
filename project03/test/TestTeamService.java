package project03.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import project03.domain.Architect;
import project03.domain.Designer;
import project03.domain.Programmer;
import project03.service.Status;
import project03.service.TeamException;
import project03.service.TeamService;

public class TestTeamService {

    static TeamService teamService;

    @Before
    public void generBaseData(){
        teamService = new TeamService();
    }

    @After
    public void teardown(){
        teamService = null;
    }
    
    @Test
    public void testAddMemberTwoProgrammer(){
        // 添加两名程序员
        String message = null;
        try {
            Programmer programmer = new Programmer();
            programmer.setId(1);
            teamService.addMember(programmer);
            programmer = new Programmer();
            programmer.setId(2);
            teamService.addMember(programmer);
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertNull(message);
        }
    }

    @Test
    public void testAddMemberThreeProgrammer(){
        // 添加三名程序员
        String message = null;
        try {
            Programmer programmer = new Programmer();
            programmer.setId(1);
            teamService.addMember(programmer);
            programmer = new Programmer();
            programmer.setId(2);
            teamService.addMember(programmer);
            programmer = new Programmer();
            programmer.setId(3);
            teamService.addMember(programmer);
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertNull(message);
        }
    }

    @Test
    public void testAddMemberFourProgrammer(){
        // 添加四名程序员，添加成员可能会失败的情况6
        String message = null;
        try {
            Programmer programmer = new Programmer();
            programmer.setId(1);
            teamService.addMember(programmer);
            programmer = new Programmer();
            programmer.setId(2);
            teamService.addMember(programmer);
            programmer = new Programmer();
            programmer.setId(3);
            teamService.addMember(programmer);
            programmer = new Programmer();
            programmer.setId(4);
            teamService.addMember(programmer);
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertTrue("不应该能添加四名程序员", 
            message.equals("团队中至多只能有三名程序员"));
        }
    }

    @Test
    public void testAddMemberThreeDesigner(){
        // 添加三名设计师，添加成员可能会失败的情况5
        String message = null;
        try {
            Designer designer = new Designer();
            designer.setId(1);
            teamService.addMember(designer);
            designer = new Designer();
            designer.setId(2);
            teamService.addMember(designer);
            designer = new Designer();
            designer.setId(3);
            teamService.addMember(designer);
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "不应能添加三名设计师",
                "团队中至多只能有两名设计师",
                message);
        }
    }

    @Test
    public void testAddMemberTwoArchitect(){
        // 添加两名架构师，添加成员可能会失败的情况4
        String message = null;
        try {
            Architect architect = new Architect();
            architect.setId(1);
            teamService.addMember(architect);
            architect = new Architect();
            architect.setId(2);
            teamService.addMember(architect);
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "不应能添加三名设计师",
                "团队中至多只能有一名架构师",
                message);
        }
    }

    @Test
    public void testAddMemberExistedMember(){
        // 添加已在当前团队的成员，情况3
        String message = null;
        try {
            Designer designer = new Designer();
            designer.setId(1);
            teamService.addMember(designer);
            // 重复添加
            teamService.addMember(designer);

        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "该成员已在本开发团队中",
                "该成员已在本开发团队中",
                message);
        }
    }

    @Test
    public void testAddMemberJoinAnother(){
        // 添加已加入其他团队的成员,情况1
        String message = null;
        try {
            Designer designer = new Designer();
            designer.setId(1);

            TeamService anotherTeam = new TeamService();
            anotherTeam.addMember(designer);
            // 添加已加入其他团队的成员
            teamService.addMember(designer);

        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "该成员已是某团队成员",
                "该成员已是某团队成员",
                message);
        }
    }

    @Test
    public void testAddMemberOnVocation(){
        // 添加正在度假的员工,情况2
        String message = null;
        try {
            Designer designer = new Designer();
            designer.setId(1);
            // 度假的员工
            designer.setStatus(Status.VOCATION);
            teamService.addMember(designer);

        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "该成员正在休假，无法添加",
                "该成员正在休假，无法添加",
                message);
        }
    }

    @Test
    public void testRemoveMemberNotInTeam(){
        // 删除不在团队的员工
        String message = null;
        int memberId = 5;
        try {
            teamService.removeMember(memberId);

        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "找不到指定memberId=" + memberId +"的员工",
                "找不到指定memberId=" + memberId +"的员工",
                message);
        }
    }

    @Test
    public void testRemoveMemberInTeam(){
        // 删除在团队的员工
        String message = null;
        int memberId = 1;
        try {
            Designer designer = new Designer();
            designer.setId(1);
            teamService.addMember(designer);
            teamService.removeMember(memberId);
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                message,
                1,
                teamService.getTotal() + teamService.getCount());

            // 增加异常校验
            assertNull("不应异常", message);
        }
    }

}
