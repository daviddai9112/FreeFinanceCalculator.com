/*
Team 5
Task 7
Date: Jan. 28, 2015
Only for educational use
 */
package model;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.RollbackException;


public class Model {
	// private CustomerDAO customerDAO;
	// private EmployeeDAO employeeDAO;
	// private FundDAO fundDAO;
	// private PositionDAO positionDAO;
	// private PriceDAO priceDAO;
	// private TransactionDAO transactionDAO;
	private UserDAO userDAO;

	public Model(ServletConfig config) throws ServletException {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriverName");
			String jdbcURL = config.getInitParameter("jdbcURL");

			ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
			userDAO = new UserDAO("user", pool);
		} catch (DAOException e) {
			throw new ServletException(e);
		}

		// try {
		// if (employeeDAO.read("admin") == null) {
		// EmployeeBean admin = new EmployeeBean();
		// admin.setFirstName("John");
		// admin.setLastName("Smith");
		// admin.setPassword("123");
		// admin.setUserName("admin");
		// employeeDAO.create(admin);
		// }
		// } catch (RollbackException e) {
		// e.printStackTrace();
		// }
	}

	// public EmployeeDAO getEmployeeDAO() { return employeeDAO; }
	// public CustomerDAO getCustomerDAO() { return customerDAO; }
	// public FundDAO geFundDAO() { return fundDAO; }
	// public PositionDAO getPositionDAO() { return positionDAO; }
	// public PriceDAO getPriceDAO() { return priceDAO; }
	// public TransactionDAO getTransactionDAO() { return transactionDAO; }
	public UserDAO getUserDAO() {
		return userDAO;
	}
}
