package com.henok.ppmtool.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private  String  projectIdentifer;
    private String description;
    private Date start_date;
    private Date end_date;

    private Date created_At;
    private Date updated_At;


    public Project() {
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectIdentifer() {
        return projectIdentifer;
    }

    public String getDescription() {
        return description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    @PrePersist
    protected void onCreate(){
        this.created_At= new Date();
    }

@PreUpdate
    protected void onUpdate(){
        this.updated_At= new Date();
}


}
