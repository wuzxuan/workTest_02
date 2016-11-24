package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import util.DBUtil;

public class EmpTest {
		public static void save(Emp emp){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into  tb_test_wzx values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
			throw new RuntimeException("增加员工失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	public static List<Emp> findImg(){
		Connection conn=null;
		try {
			 conn=DBUtil.getConnection();
			Statement smt=conn.createStatement();
			String  sql="select * from tb_test_wzx";
			ResultSet rs=smt.executeQuery(sql);
			List <Emp> list=new ArrayList<Emp>();
 			while(rs.next()){
				Emp e = createEmp(rs);
				list.add(e);
			}
 			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询员工失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}

	private static Emp createEmp(ResultSet rs) throws SQLException {
		Emp e=new Emp();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		return e;
	}
	
	
	public static void main(String[] args) {
		Emp e=new Emp();
		e.setId(2);
		e.setName("asd");
		save(e);
		System.out.println("信息插入成功");
		System.out.println(findImg());
	}
}
