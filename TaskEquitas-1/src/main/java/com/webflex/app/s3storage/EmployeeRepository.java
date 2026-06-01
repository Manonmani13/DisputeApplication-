

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.webflex.app.s3storage.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}