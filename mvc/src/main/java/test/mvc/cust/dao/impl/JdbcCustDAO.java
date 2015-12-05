package test.mvc.cust.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import test.mvc.cust.dao.CustDAO;
import test.mvc.cust.model.Cust;

public class JdbcCustDAO implements CustDAO{

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Cust customer) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO CUST " +
				"(NAME, AGE) VALUES (?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setInt(1, customer.getCustId());
			ps.setString(1, customer.getName());
			ps.setInt(2, customer.getAge());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public Cust findByCustomerId(int custId) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CUST WHERE CUST_ID = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, custId);
			Cust customer = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Cust(
					rs.getInt("CUST_ID"),
					rs.getString("NAME"), 
					rs.getInt("Age")
				);
			}
			rs.close();
			ps.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
