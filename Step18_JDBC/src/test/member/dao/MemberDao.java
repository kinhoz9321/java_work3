package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *  회원정보(member 테이블) 의 내용을
 *  select
 *  insert
 *  update
 *  delete 
 *  작업을 할 객체를 생성할 클래스 설계하기 
 *  
 *  - 필요한 객체를 담을 지역변수를 선언하는 위치도 중요하다.
 *  - 필요한 객체를 생성하는 위치도 중요하다.
 *  
 *  Data Access Object (DAO)
 *  
 *  - DB 에 INSERT, UPDATE, DELETE, SELECT 작업을 수행하는 객체
 *  - Table 마다 하나의 DAO 혹은  주제(카테고리) 마다 하나의 DAO 를 작성하게 된다.
 *  - DAO 를 만들기 위해서는 DTO 클래스를 미리 설계를 하고 만들어야 한다.
 *  - 주제(카테고리) 에 관련된 DAO 는 여러개의 Table 의 join 이 일어 날수도 있다.
 *    따라서 하나의 Table 당 하나의 DAO 는 아닌것이다. 
 *    예를 들어 사원정보를 출력한다고 가정을 해 보면
 *    emp, dept, salgrade 3개의 테이블의 join 이 일어날수도 있다.  
 * 
 * 코드 분석해보기
 * rs=pstmt.executeQuery();
 * flag=pstmt.executeUpdate();
 * 
 * sql문과 ? 바인딩
 */

public class MemberDao {
	//모든 회원의 정보를 SELECT 해서 리턴하는 메소드
	public List<MemberDto> selectAll(){
		List<MemberDto> list=new ArrayList<MemberDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT num,name,addr FROM member ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				MemberDto dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				list.add(dto);
			}
		} catch (Exception e) {
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
		return list;
	}
	
	//회원 한명의 정보를 SELECT 해서 리턴하는 메소드
	public MemberDto select(int num) {
		
		MemberDto dto=null;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name, addr FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				if(rs!=null)rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	//1. 회원 한명의 정보를 저장하는 메소드를 만들어 보세요.
	// 메소드명 : insert
	// 리턴 type : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	public boolean insert(MemberDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			conn=new DBConnect().getConn();
			String sql="INSERT INTO member"
					+ " (num, name, addr)"
					+ " VALUES (member_seq.NEXTVAL, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			flag=pstmt.executeUpdate();
			
			System.out.println("회원 정보를 저장했습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//2. 회원 한명의 정보를 수정하는 메소드를 만들어 보세요.
	// 메소드명 : update
	// 리턴 type : 알아서
	// 메소드에 전달하는 인자의 type : MemberDto
	public boolean update(MemberDto dto) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			conn=new DBConnect().getConn();
			String sql="UPDATE member SET name=?, addr=? WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			
			flag=pstmt.executeUpdate();
			System.out.println("회원 정보를 수정 했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				
			}
		}
		if (flag>0) {
			return true;
		} else {
			return false;
		}
	}
	
	//회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		
		//필요한 참조값을 담을 지역 변수 미리 만들고 초기화 하기
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			//Connection 객체의 참조값 얻어오기
			conn=new DBConnect().getConn();
			//실행할 sql 문의 뼈대 준비하기
			String sql="DELETE FROM member WHERE num=?";
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			//? 에 값 바인딩 하기
			pstmt.setInt(1, num);
			//sql 문 실행하고 변화된 row 의 갯수 리턴 받기
			flag=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//마무리 작업
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();				
			}catch (Exception e) {
				
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
}
