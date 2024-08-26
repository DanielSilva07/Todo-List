package br.com.danielsilva.demo1.repository;

import br.com.danielsilva.demo1.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends CrudRepository<Task , Long> {



}