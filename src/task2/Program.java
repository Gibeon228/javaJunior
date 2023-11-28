package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */
public class Program {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // region 2.1 Создать список из 10-20 сотрудников
        for (int i = 1; i < 11; i++) {
            String name = "name" + i;
            String department = "department" + (i + 1) / 2;
            Employee employee = new Employee(name, i + 18, i * 2000, department);
            employees.add(employee);
        }
        // endregion

        // region 2.2 Вывести список всех различных отделов (department) по списку сотрудников
            employees.stream().map(employee -> employee.getDepartment()).distinct().forEach(System.out::println);
        // endregion

        // region 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        employees.stream().filter(employee -> employee.getSalary() < 10_000).forEach(employee -> employee.setSalary(employee.getSalary() * 1.2));
        //endregion

        // region 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> departmentWithEmployee = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        // endregion

        // region 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> departmentWithAverageSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        // endregion
    }
}
