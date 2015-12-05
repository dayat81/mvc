package test.mvc.cust.dao;

import test.mvc.cust.model.Cust;

public interface CustDAO {
	public void insert(Cust customer);
	public Cust findByCustomerId(int custId);
}
