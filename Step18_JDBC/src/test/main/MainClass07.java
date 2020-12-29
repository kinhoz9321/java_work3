package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Scanner 객체를 이용해서 검색할 회원의 번호를 입력 받아서
 *  입력받은 숫자를 이용해서 SELECT 문을 수행하고 
 *  결과값을 MemberDto 객체를 생성해서 담아 보세요.
 *  
 *  결과가 없다면 MemberDto 객체를 생성하지 마세요 ( null 인 상태로 두기 )
 */

public class MainClass07 {
	public static void main(String[] args) {
		
		//1. Scanner 객체를 이용해서 검색할 회원의 정보를 입력 받기
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 번호 입력 :");
		//2. 입력받은 '숫자'를 이용
		int num=scan.nextInt();
		
		//3. SELECT 문을 수행하기. 우선 DB 연동, 기본값을 담은 객체 생성 필요
		//검색된 회원 정보가 담길 MemberDto 객체의 참조값을 담을 지역변수 생성
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//DBConnect 객체를 이용해서 Connection 객체의 참조값 얻어내기
			conn=new DBConnect().getConn();
			//실행할 sql문 (SELECT) 의 뼈대 구성하기 (미완성)
			String sql="SELECT name, addr FROM member WHERE num=?";
			//sql문을 대신 실행해줄 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//? 에 값 바인딩하기
			pstmt.setInt(1, num);
			//SELECT 문 수행하고 결과를 ResultSet 으로 받기
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//SELECT 된 결과가 있다면 (1개=if)
				//MemberDto 객체를 생성해서
				dto=new MemberDto();
				//setter 메소드를 이용해서 값을 담는다.
				dto.setNum(num);
				//ResultSet 객체에 있는 값도 얻어와서 담아준다.
				String name=rs.getString("name");
				//담지 않으면 값은 null로 표시됨.
				dto.setName(name);
				String addr=rs.getString("addr");
				dto.setAddr(addr);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		//위의 try~catch~finally 절이 수행된 후에 SELECT 된 결과가 있는지 없는지를 쉽게 판별할 수 있는 방법은? 
		//dto가 null인지, 아닌지로 구분한다.
		if(dto==null) {
			System.out.println(num+" 번 회원은 존재하지 않습니다.");
		}else {
			System.out.println("번호:"+dto.getNum()+", 이름:"+dto.getName()+", 주소:"+dto.getAddr());
		}
	}
}
