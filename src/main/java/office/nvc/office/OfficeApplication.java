package office.nvc.office;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import office.nvc.office.model.Department;
import office.nvc.office.model.Employee;
import office.nvc.office.model.Project;
import office.nvc.office.repository.DepartmentRepository;
import office.nvc.office.repository.EmployeeRepository;
import office.nvc.office.repository.ProjectRepository;

@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(OfficeApplication.class);

	private final DepartmentRepository departmentRepository;
	private final EmployeeRepository employeeRepository;
	private final ProjectRepository projectRepository;

	

	public OfficeApplication(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository,
			ProjectRepository projectRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
		this.projectRepository = projectRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Department dpm1 = new Department("lkbbklhbkjb");
		Department dpm2 = new Department("kbglyig");
		departmentRepository.saveAll(Arrays.asList(dpm1,dpm2));
		
		Project pj1 = new Project("elderycard");
		Project pj2 = new Project("Cake");
		projectRepository.saveAll(Arrays.asList(pj1,pj2));

		employeeRepository.save(new Employee("Phet", 10000, dpm1, pj1));
		employeeRepository.save(new Employee("ikkyu", 20000, dpm2, pj2));

		for (Employee employee : employeeRepository.findAll()) {
			logger.info("Name: {}, Salary:{}",
					employee.getName(),employee.getSalary() );
		}
		logger.info("---------------- Start find By Name ---------------");
		for (Employee employee : employeeRepository.findByName("Phet")) {
			logger.info("Name: {} , Salary:{}",
					employee.getName(), employee.getSalary());
		}
		logger.info("---------------- Start find By salary GreaterThan 10000 ---------------");
		for (Employee employee : employeeRepository.findBySalaryGreaterThan(10000)) {
			logger.info("Name: {} , Salary:{}",
					employee.getName(), employee.getSalary());
		}
		logger.info("---------------- Start find By salary GreaterThan 1000 ---------------");
		for (Employee employee : employeeRepository.findBySalaryGreaterThan(1000)) {
			logger.info("Name: {} , Salary:{}",
					employee.getName(), employee.getSalary());
		}
		logger.info("---------------- Start find By salary Containing ---------------");
		for (Project project : projectRepository.findByNameContaining("elder")) {
			logger.info("Name: {} ",
					project.getName());
		}




	}
}
