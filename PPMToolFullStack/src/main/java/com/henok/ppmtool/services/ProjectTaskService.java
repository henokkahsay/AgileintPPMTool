package com.henok.ppmtool.services;


import com.henok.ppmtool.domain.Backlog;
import com.henok.ppmtool.domain.Project;
import com.henok.ppmtool.domain.ProjectTask;
import com.henok.ppmtool.exaptions.ProjectNotFoundException;
import com.henok.ppmtool.repositories.BacklogRepository;
import com.henok.ppmtool.repositories.ProjectRepository;
import com.henok.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

@Autowired
    private BacklogRepository backlogRepository;



    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;
    public ProjectTask addProjectTask(String projectIdentifier,ProjectTask projectTask){

    try{




        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);



        projectTask.setBacklog(backlog);
        Integer BacklogSequence = backlog.getPTSequence();
        BacklogSequence++;
        backlog.setPTSequence(BacklogSequence);
        projectTask.setProjectSequence(projectIdentifier+"="+BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);



        if (projectTask.getStatus()==""|| projectTask.getStatus()==null){
            projectTask.setStatus("TO_DO");
        }
        if (projectTask.getPriority()==null){
            projectTask.setPriority(3);
        }
        return projectTaskRepository.save(projectTask);
    }catch (Exception e){
        throw  new ProjectNotFoundException("Project not Found");
    }

    }






 public Iterable<ProjectTask>findBacklogByid(String  id){

     Project project=projectRepository.findByProjectIdentifier(id);

        if (project==null){
            throw new ProjectNotFoundException("Project with ID: '"+id+"' does not exist");
        }

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
}


public  ProjectTask findPtByProjectSequence(String backlog_id,String pt_id ){
Backlog backlog=backlogRepository.findByProjectIdentifier(backlog_id);
if (backlog==null){
    throw new ProjectNotFoundException("Project with ID: '"+backlog_id+"' does not exist");
}
ProjectTask projectTask=projectTaskRepository.findByProjectSequence(pt_id);
if (projectTask==null){
    throw new ProjectNotFoundException("Project Task '"+pt_id+"' not found");

}
if (!projectTask.getProjectIdentifier().equals(backlog_id)){
    throw new ProjectNotFoundException("Project Task '"+pt_id+"' does not exist in project:'"+backlog_id);
}


return projectTask;
    }

    public ProjectTask updateByProjectSequence(ProjectTask updatedTask, String backlog_id,String pt_id){
        ProjectTask projectTask=findPtByProjectSequence(backlog_id,pt_id);
        projectTask=updatedTask;
        return projectTaskRepository.save(projectTask);
    }
    public void deletePTByProjectSequence(String backlog_id,String pt_id){
        ProjectTask projectTask=findPtByProjectSequence(backlog_id,pt_id);
        projectTaskRepository.delete(projectTask);

    }



}

