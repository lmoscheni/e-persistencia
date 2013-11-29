package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.util.SessionManager;

public class EmployeeDAO {

	public Employee getByName(final String name, final String lastName) {
		Session session = SessionManager.getSession();
		return (Employee) session
				.createQuery(
						"from Employee where firstName = :name and lastName = :lastName")
				.setParameter("name", name).setParameter("lastName", lastName)
				.uniqueResult();
				
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		Session session = SessionManager.getSession();
		return session.createQuery("from Employee e inner join e.salaries s order by s.amount").list();
	}

	public Employee getByCode(int id) {
		Session session = SessionManager.getSession();
		return (Employee) session.load(Employee.class, id);
	}
	
	public List<Employee> maxSalaries(){
		Session session = SessionManager.getSession();
		return (List<Employee>) session
				.createQuery("select new Employee(emp.firstName, s.amount) " +
									"from Employee emp " +
									"inner join emp.salaries s " +
									"where s.to = '9999-01-01' " + 
									"order by s.amount desc").setMaxResults(10)
									.list();
	}

}


		








