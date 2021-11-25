package com.fidesol.bcp.infrastructure;

import com.fidesol.bcp.domain.model.mysql.Project;
import com.fidesol.bcp.domain.repository.mysql.ProjectRepository;
import com.fidesol.bcp.service.ProjectService;
import com.fidesol.bcp.service.dtos.ProjectData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ProjectService")
public class ProjectServiceImplementation implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    //Add a new project
    public int addProject(ProjectData data){
        projectRepository.add(data.getName(),data.getUrl(),data.getDescripcion());

        return projectRepository.getId(data.getName());
    }

    //Get the full projects list
    public List<ProjectData> list(){
        List<Project> data= projectRepository.findAll();
        List<ProjectData> output = new ArrayList<>();
        ProjectData aux = new ProjectData();

        data.stream().forEach(proyecto->{
/*            aux.setName();
            aux.setUrl(proyecto.getUrl());
            aux.setDescripcion(proyecto.getDescripcion());*/
            output.add(new ProjectData(proyecto.getIdHateword(),proyecto.getName(),proyecto.getUrl(),proyecto.getDescripcion()));
        });

        return output;
    }
}
