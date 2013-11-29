package unq.tpi.persistencia.performanceEj.daos;

import java.util.List;

import org.hibernate.classic.Session;

import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;
import unq.tpi.persistencia.util.SessionManager;

public class DepartmentDAO {

	public List<Employee> getByName(final String name) {
		Session session = SessionManager.getSession();
		List list = session
				.createQuery("select new Employee(emp.firstName, s.amount, t) " +
									"from Department this inner join this.employees emp " +
									"inner join emp.salaries s inner join emp.titles t " +
									"where this.name = :name and s.to = '9999-01-01'")
				.setParameter("name", name).list();
		return (List<Employee>) list;
	}

	public Department getByCode(String number) {
//		Session session = SessionManager.getSession();
//		return (Department) session
//				.createQuery("from Department dep " +
//								"inner join fetch dep.employees emp " +
//								"inner join fetch emp.salaries inner join fetch emp.titles " +
//								"where dep.number = :number")
//				.setParameter("number", number).uniqueResult();
		Session session = SessionManager.getSession();
		return (Department) session
				.createQuery("from Department dep " +
								"where dep.number = :number")
				.setParameter("number", number).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Department> getAll() {
		Session session = SessionManager.getSession();
		return session.createQuery("from Department").list();
	}

}
