package com.henok.ppmtool.repositories;

import com.henok.ppmtool.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

<<<<<<< Updated upstream

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {

List<ProjectTask> findByProjectIdentifierOrderByPriority(String  id);
}
=======
@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);
}
>>>>>>> Stashed changes
