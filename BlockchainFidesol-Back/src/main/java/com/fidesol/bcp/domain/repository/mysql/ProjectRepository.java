package com.fidesol.bcp.domain.repository.mysql;

import com.fidesol.bcp.domain.model.mysql.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

    /**
     * This query insert a new entry in proyectos table.

     * @param String, String, String
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `proyectos` (`name`, `url`, `descripcion`) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void add(String name, String url, String descripcion);

    /**
     * This query obtains the id of a given project name.

     * @param String
     */
    @Query(value = "SELECT id from proyectos WHERE name=?1", nativeQuery = true)
    int getId(String name);
}
