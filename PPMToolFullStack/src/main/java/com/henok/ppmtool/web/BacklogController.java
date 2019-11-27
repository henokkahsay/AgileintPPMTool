package com.henok.ppmtool.web;


import com.henok.ppmtool.domain.ProjectTask;
import com.henok.ppmtool.services.MapValidationErrorService;
import com.henok.ppmtool.services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/backlog")
@CrossOrigin
public class BacklogController {

@Autowired
    private ProjectTaskService projectTaskService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;



    @PostMapping("/{backlog_id}")
    public ResponseEntity<?> addPTtoBacklog(@Valid @RequestBody ProjectTask projectTask,
                                            BindingResult result,@PathVariable String backlog_id){

               ResponseEntity<?>errorMap=mapValidationErrorService.MapValidationService(result);
               if (errorMap!= null) return errorMap;

               ProjectTask projectTask1=projectTaskService.addProjectTask(backlog_id,projectTask);
               return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.CREATED);
    }
    @GetMapping("/{backlog_id}")
    public Iterable<ProjectTask> getProjectBackLog(@PathVariable String backlog_id){
        return projectTaskService.findBacklogByid(backlog_id);
    }
    @GetMapping("/{backlog_id}/{pt_id}")
    public ResponseEntity<?>getProjectTask(@PathVariable String backlog_id,@PathVariable String pt_id){
        ProjectTask projectTask=projectTaskService.findPtByProjectSequence(backlog_id ,pt_id);
        return new ResponseEntity<ProjectTask>(projectTask,HttpStatus.OK);
    }

    @PostMapping("/{backlog_id}/{pt_id}")
    public ResponseEntity<?> updateProjectTask(@Valid @RequestBody ProjectTask projectTask,BindingResult result,
                                               @PathVariable String backlog_id, @PathVariable String pt_id){
        ResponseEntity<?>errorMap=mapValidationErrorService.MapValidationService(result);
        if (errorMap!= null) return errorMap;
     ProjectTask updatedTask= projectTaskService.updateByProjectSequence(projectTask,backlog_id,pt_id);
   return  new ResponseEntity<ProjectTask>(updatedTask,HttpStatus.OK);
     }
}