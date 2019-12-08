package com.henok.ppmtool.repositories;

import com.henok.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project , Long> {
   Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();
    Iterable<Project>findAllByProjectLeader(String username);
}
