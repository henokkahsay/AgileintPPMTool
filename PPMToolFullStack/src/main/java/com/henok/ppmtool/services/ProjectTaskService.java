package com.henok.ppmtool.services;

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
    public ProjectTask addProjectTask()
    {
     
    }
}
