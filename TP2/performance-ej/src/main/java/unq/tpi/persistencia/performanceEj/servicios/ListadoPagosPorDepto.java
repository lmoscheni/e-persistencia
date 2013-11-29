package unq.tpi.persistencia.performanceEj.servicios;

import java.util.List;

import unq.tpi.persistencia.performanceEj.daos.DepartmentDAO;
import unq.tpi.persistencia.performanceEj.model.Department;
import unq.tpi.persistencia.performanceEj.model.Employee;

public class ListadoPagosPorDepto extends AbstractListado {

	private String num;
	private List<Employee> employees = null;

	public ListadoPagosPorDepto(String num) {
		this.num = num;
	}

	@Override
	protected void doListado() throws Exception {
		employees = new DepartmentDAO().getByName(num);
		double counter = 0;
		
		
		this.newLine();
		this.addColumn("Nombre");
		this.addColumn("Monto");
		this.addColumn("Titulo");
		this.newLine();

		for (Employee e : employees) {
			counter += e.getSalaries().get(0).getAmount();
			this.addColumn(e.getFirstName());
			this.addColumn(e.getTitle());
			this.addColumn(e.getSalary());
			this.newLine();
		}
		
		this.addColumn("Total").addColumn(counter).newLine();
		this.newLine();
		
	}

	@Override
	public String getFilename() {
		return "./target/PagosPorDepto.csv";
	}
}
