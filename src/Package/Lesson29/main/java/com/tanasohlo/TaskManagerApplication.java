package Package.Lesson29.main.java.com.tanasohlo;

import Package.Lesson29.main.java.com.tanasohlo.model.Employee;
import Package.Lesson29.main.java.com.tanasohlo.model.Task;
import Package.Lesson29.main.java.com.tanasohlo.service.AssignTaskService;
import Package.Lesson29.main.java.com.tanasohlo.service.EmployeeService;
import Package.Lesson29.main.java.com.tanasohlo.service.TaskService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class TaskManagerApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("Package.Lesson29.main");

		TaskService taskService = applicationContext.getBean(TaskService.class);
		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
		AssignTaskService assignTaskService = applicationContext.getBean(AssignTaskService.class);



		Task task1 = taskService.create("Clean", BigDecimal.valueOf(144.0));
		Task task2 = taskService.create("Build", BigDecimal.valueOf(54.9));
		Task task3 = taskService.create("Construct", BigDecimal.valueOf(234.35));

		Employee employee1 = employeeService.create("Ivanov");
		Employee employee2 = employeeService.create("Petrov");
		Employee employee3 = employeeService.create("Sidorov");

		assignTaskService.assignTask(employee1, task1);
		assignTaskService.assignTask(employee2, task2);
		assignTaskService.assignTask(employee3, task3);


		List<Task> taskList = taskService.findAll();
		for (Task currentTask : taskList) {
			System.out.println("Task " + currentTask.getName() + " with price " + currentTask.getPrice() + " is assigned to " + currentTask.getAssignee().getName());
		}
	}





}
