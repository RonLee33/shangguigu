package project03.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import project03.domain.Designer;
import project03.domain.Programmer;
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
            teamService.addMember(new Programmer());
            teamService.addMember(new Programmer());
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
            teamService.addMember(new Programmer());
            teamService.addMember(new Programmer());
            teamService.addMember(new Programmer());
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
            teamService.addMember(new Programmer());
            teamService.addMember(new Programmer());
            teamService.addMember(new Programmer());
            teamService.addMember(new Programmer());
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
            teamService.addMember(new Designer());
            teamService.addMember(new Designer());
            teamService.addMember(new Designer());
        } catch (TeamException e){
            message = e.getMessage();
        } finally {
            assertEquals(
                "不应能添加三名设计师",
                "团队中至多只能有两名设计师",
                message);
        }
    }

}