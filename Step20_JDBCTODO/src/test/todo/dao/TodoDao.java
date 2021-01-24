package test.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.todo.dto.TodoDto;
import test.util.DBConnect;

public class TodoDao {

	//모든 할일 목록을 SELECT 해서 리턴하는 메소드
	public List<TodoDto> selectAll(){
		List<TodoDto> list=new ArrayList<TodoDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn=new DBConnect().getConn();
			
			String sql="SELECT num, content,"
					+ " TO_CHAR(regdate, 'YYYY\"년\"MM\"월\"DD\"일\" AM HH\"시\"MI\"분\"') AS regdate"
					//칼럼에 별칭을 안두면 TO_CHAR(regdate, 'YYYY.MM.DD AM HH:MI') 이렇게 써야함
					//여기서 날짜 스타일 바꿔주기
					+ " FROM todo"
					+ " ORDER BY num DESC";
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TodoDto dto=new TodoDto();
				dto.setNum(rs.getInt("num"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {}
		}
		return list;
	}
		
		
	
	//할일 목록 1개를 저장하는 메소드
	public boolean insert(TodoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			
			conn=new DBConnect().getConn();
			String sql="INSERT INTO todo"
					+ " (num, content, regdate)"
					+ " VALUES(todo_seq.NEXTVAL, ?, SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			
			flag=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			} catch (Exception e2) {
				
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	//할일 목록 1개를 수정하는 메소드
	public boolean update(TodoDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			
			conn=new DBConnect().getConn();
			String sql="UPDATE todo"
					+ " SET content=?, regdate=?"
					+ " WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getRegdate());
			pstmt.setInt(3, dto.getNum());
			
			flag=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			} catch (Exception e2) {
				
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//할일 목록 1개를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		
		try {
			
			conn=new DBConnect().getConn();
			String sql="DELETE FROM todo WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
				
			} catch (Exception e2) {
				
			}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
}
