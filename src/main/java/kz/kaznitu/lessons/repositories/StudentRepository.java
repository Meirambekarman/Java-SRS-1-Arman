package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
