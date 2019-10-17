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
    public Project findByProjectIdentifier(String projectId) {
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if (project == null){
            throw  new ProjectIdException("Project ID ' "+projectId+" ' does not exists");

        }
        return project;
    }
public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
}
public void deleteProjectByIdentifier(String projectid){
        Project project=projectRepository.findByProjectIdentifier(projectid.toUpperCase());
        if (project == null ){
            throw new ProjectIdException("Cannot Project with ID '"+projectid+"'.this project does not exist");
        }
    projectRepository.delete(project);
    }


        }
