package com.fidesol.bcp.service;

import com.fidesol.bcp.service.dtos.ProjectData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    int addProject(ProjectData data);

    List<ProjectData> list();
}
