package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.util.DBConnect;

/*
 *   Scanner 객체를 이용해서 검색할 회원의 번호를 입력 받아서
 *   DB 에서 SELECT 하고 
 *   결과 값이 있으면 해당 회원의 정보를 콘솔창에 출력하고
 *   결과 값이 없으면 해당 회원은 존재 하지 않습니다. 라고 출력되는 프로그래밍을 해 보세요
 *   hint : String sql="SELECT num,name,addr FROM member WHERE num=?";
 *   예)
 *   검색할 회원번호 입력:
 *   801
 *   801 번 회원은 존재 하지 않습니다.
 *   
 *   예)
 *   검색할 회원번호 입력:
 *   850
 *   번호 : 850, 이름 : 톰캣, 주소 : 건물 옥상
 */

public class MainClass06 {
	public static void main(String[] args) {
		//콘솔창으로부터 입력 받을 객체 생성
		Scanner scan=new Scanner(System.in);
		//콘솔창에 입력한 값을 정수로 얻어낸다.
		System.out.println("검색할 회원 번호 입력:");
		//회원의 번호를 담은 변수
		int num=scan.nextInt();
		
		//필요한 객체를 담을 지역변수 미리 만들기
		//DB 연결 객체를 담을 지역 변수
		Connection conn=null;
		//sql 문을 대신 실행해주는 PreparedStatement 지역변수
		PreparedStatement pstmt=null;
		//결과 데이터가 포장되는 지역 변수
		ResultSet rs=null;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 SELECT 문의 뼈대 준비하기
			String sql="SELECT name, addr FROM member WHERE num=?";
			//PreparedStatement 객체
			pstmt=conn.prepareStatement(sql);
			//? 에 값 바인딩해서 SELECT 문 완성하기
			pstmt.setInt(1, num);
			//쿼리문(SELECT) 수행하고 결과를 ResultSet 으로 받아오기
			rs=pstmt.executeQuery();
			
			/*
			 * member table 에서 num은 PRIMARY KEY 값이다.
			 * 따라서 SELECT 된 결과 row 의 갯수는
			 * 0 이거나 1 이 된다.
			 * 
			 * primary key 이기 때문에 최대 1개.
			 * 그 말은 반복문이 필요없다는 말.
			 * while 문 이 아닌 if 문으로 사용.
			 */
			
			if(rs.next()) {//boolean isExist=rs.next(); 가능. true가 1번만 나오면 되기 때문.
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println("번호:"+num+", 이름:"+num+", 주소:"+addr);
			}else {
				System.out.println(num+" 번 회원은 존재하지 않습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				
			}
		}
	}
}
