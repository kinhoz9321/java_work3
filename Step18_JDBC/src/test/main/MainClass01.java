package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Java DataBase Connectivity (JDBC)
 * 
 * - Oracle 에 연결하기 위해서는 드라이버가 들어있는 ojdbc6.jar 파일이 필요하다
 * - 프로젝트 설정에서 ojdbc6.jar 를 사용할 준비를 해야한다.
 */

public class MainClass01 {
	public static void main(String[] args) {
		
		//DB 연결 객체를 담을 지역변수 (여러 메소드 안에서 쓰여질 것은 꼭 지역 변수에 담아야 한다.)
		Connection conn=null;
		
		try {
			
			/* 
			 * 드라이버 로딩 (DB 연동을 위해서 꼭 필요)
			 * ojdbc6.jar 가 없으면 이곳에서 오류가 난다.
			 * oracle class is not found Exception 발생
			 */
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//접속할 DB 정보
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			//String url="jdbc:oracle:thin:@localhost:1521:xe";
			
			//접속하고 Connection 객체의 참조값 얻어오기 (아이디, 비밀번호 String type)
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			//conn=DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("Oracle DB 접속 성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Member 테이블의 내용을 select 해서 console에 출력해보기
		PreparedStatement pstmt=null;
		//try 블럭 밖에서도 사용하기 위해 ResultSet을 밖에 선언. (결과 데이터가 포장되는 곳)
		ResultSet rs=null;
		
		try {
			String sql="SELECT num,name,addr FROM member ORDER BY num ASC";
			
			//SQL문을 대신 실행해주는 PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			
			/*
			 * SELECT 문 수행하고 결과 row를 ResultSet 객체로 받아오기
			 * excuteQuery(); 는 데이터의 셀렉트 된 결과를 담은 ResultSet을 리턴한다.
			 * 결과값은 테이블 형식 (컬럼과 로우)로 구성이 된다.
			 */
			
			rs=pstmt.executeQuery();
			
			/*
			 * rs.next() 메소드가 false를 리턴할 때까지 while 반복문 돌기
			 * (만약 row가 하나도 없으면 처음부터 false 리턴)
			 */
			
			while(rs.next()) {//next() 커서가 위치한 곳에서 row 데이터를 읽어내겠다.
				
				/*
				 * 결과 row가 담긴 rs를 이용해서 
				 * TYPE 변수명=rs.getTYPE("칼럼명"); ? 질문 getActionCommand?
				 * 칼럼의 값 타입 맞춰서 얻어내기
				 */
				
				//현재 커서가 위치한 곳에서 num 칼럼의 값을 정수로 얻어내기
				int num=rs.getInt("num");
				//현재 커서가 위치한 곳에서 name 칼럼의 값을 문자로 얻어내기
				String name=rs.getString("name");
				//현재 커서가 위치한 곳에서 addr 칼럼의 값을 문자로 얻어내기
				String addr=rs.getString("addr");
				//콘솔에 출력하기
				System.out.println(num+"|"+name+"|"+addr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {

			}
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
/* 
 * if문으로 null인지 아닌지 구분하고 닫는 이유.
 * 
 * if(rs!=null)rs.close();
 * if(pstmt!=null)pstmt.close();
 * if(conn!=null)conn.close();
 * 
 * rs=pstmt.executeQuery(); 수행하다가 예외가 발생.(ex. 오타발생)
 * 그러면 rs가 null인 상태. 예외가 발생하면 catch로 간다. 예외정보를 출력.
 * catch를 지나서 finally 로 이동.
 * rs의 메소드를 호출하려고 하는데 참조값이 없으면 nullpointException(예외)이 발생한다.
 * 그러면 실행순서가 다시  catch로 뛰어버림.
 * 다른 마무리 작업은 실행을 못하게 된다. 
 * (ex. if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();)
 * 
 * 그러므로 작업을 하다가 어떤 객체가 null인지 아닌지 확인을 해야하는 상황이 있을 때는
 * 꼭 if문으로 nullpointException을 방지 해준다.
 */