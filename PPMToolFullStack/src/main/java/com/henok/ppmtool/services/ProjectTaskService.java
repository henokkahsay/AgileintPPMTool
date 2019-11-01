package com.henok.ppmtool.services;

import com.henok.ppmtool.domain.Backlog;
import com.henok.ppmtool.domain.ProjectTask;
import com.henok.ppmtool.repositories.BacklogRepository;
import com.henok.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private BacklogRepository backlogRepository;
    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);

        projectTask.setBacklog(backlog);

        Integer BackLongSequence = backlog.getPTSequence();

        BackLongSequence++;
        backlog.setPTSequence(BackLongSequence);

        projectTask.setProjectSequence(projectIdentifier + "-" + BackLongSequence);

        projectTask.setProjectIdentifier(projectIdentifier);



        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
                projectTask.setStatus("TO_DO");

            }
        if ( projectTask.getPriority() == null) {
            projectTask.setPriority(3);
        }

            return projectTaskRepository.save(projectTask);
        }
      public   Iterable<ProjectTask>findBacklogById(String id){
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
        }
    }


