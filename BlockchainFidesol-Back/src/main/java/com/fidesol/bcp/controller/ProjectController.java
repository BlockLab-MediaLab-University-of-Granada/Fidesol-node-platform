package com.fidesol.bcp.controller;

import com.fidesol.bcp.config.MysqlConfig;
import com.fidesol.bcp.exception.ResourceNotFoundException;
import com.fidesol.bcp.service.ProjectService;
import com.fidesol.bcp.service.dtos.ProjectData;
import com.fidesol.bcp.service.dtos.UserData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ContextConfiguration(classes = {MysqlConfig.class})
@RequestMapping("/project-management")
@Api(tags = "Proyectos")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * Add a new project to the repository.
     *
     * @param ProjectData
     * @return
     */

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody ProjectData data) throws ResourceNotFoundException {
        return ResponseEntity.ok(projectService.addProject(data));
    }

    /**
     * Obtains the projects list.
     *
     * @param 
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProjectData>> list() throws ResourceNotFoundException {
        return ResponseEntity.ok(projectService.list());
    }
}
