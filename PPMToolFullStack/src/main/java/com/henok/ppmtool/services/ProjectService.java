package com.henok.ppmtool.services;

import com.henok.ppmtool.domain.Project;
import com.henok.ppmtool.exaptions.ProjectIdException;
import com.henok.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        }catch (Exception e){
            throw  new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exiists");
        }

    }

        }