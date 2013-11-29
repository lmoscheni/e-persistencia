package unq.tpi.persistencia.performanceEj.servicios;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.EmployeeDAO;
import unq.tpi.persistencia.performanceEj.model.Employee;

public class ListadoMaximosSalarios extends AbstractListado{

	@Override
	protected String getFilename() {
		return "./target/MaximosSalarios.csv";
	}

	@Override
	protected void doListado() throws Exception {
		List<Employee> empleados = new EmployeeDAO().maxSalaries();
//		Collections.sort(empleados, new Comparator<Employee>() {
//			public int compare(Employee o1, Employee o2) {
//				return o2.getSalary().compareTo(o1.getSalary());
//			}
//		});
		
		addColumn("Nombre").addColumn("Sueldo").newLine();
		
		for(Employee employe:empleados){
			addColumn(employe.getFirstName()).addColumn(employe.getMaxSalary()).newLine();
		}
	}

}
