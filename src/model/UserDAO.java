
package model;

import java.util.Arrays;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;
import org.genericdao.Transaction;

import databeans.UserBean;


public class UserDAO extends GenericDAO<UserBean> {
	

	public UserDAO(String tableName, ConnectionPool pool) throws DAOException {
		super(UserBean.class, tableName, pool);
	}
	
	public UserBean[] getCustomers() throws RollbackException {
		UserBean[] customers = match();
		Arrays.sort(customers);  // We want them sorted by last and first names (as per Customer.compareTo());
		return customers;
	}
	
	public void setPassword(int customerId, String password) throws RollbackException {
        try {
        	Transaction.begin();
			UserBean dbCustomer = read(customerId);
			
			if (dbCustomer == null) {
				throw new RollbackException("Email Address "+ customerId +" no longer exists");
			}
			
			//dbCustomer.setPassword(password);
			
			update(dbCustomer);
			Transaction.commit();
		} finally {
			if (Transaction.isActive()) Transaction.rollback();
		}
	}
	
	public UserBean getCustomerByEmail(String email) throws RollbackException {
			UserBean[] dbCustomer = match(MatchArg.equals("email", email));
			if (dbCustomer.length == 0) return null;
			return dbCustomer[0];

	}
}
