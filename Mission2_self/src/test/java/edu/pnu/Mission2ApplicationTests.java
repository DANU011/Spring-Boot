
package edu.pnu;
   
   import java.util.List;
   
   import org.junit.jupiter.api.Test; import
   org.springframework.beans.factory.annotation.Autowired; import
   org.springframework.boot.test.context.SpringBootTest;
   
   import edu.pnu.dao.MemberDao; import edu.pnu.domain.MemberVO;
   
   @SpringBootTest //이 클래스 테스트용으로 
   class Mission2ApplicationTests {
   //@Autowired MemberDao memberDao;
   
   @Test //이 메서드를 테스트용으로 
   void contextLoads() {
	   System.out.println("0328테스트"); 
	   }
   }
