package com.fidesol.bcp.domain.model.mysql;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity(name = "Proyects")
@EnableAutoConfiguration
@Table(name = "proyectos")
public class Project {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHateword;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "descripcion")
    private String descripcion;

    public Project() {
    }

    public Project(int idHateword, String name, String url, String descripcion) {
        this.idHateword = idHateword;
        this.name = name;
        this.url = url;
        this.descripcion = descripcion;
    }

    public int getIdHateword() {
        return idHateword;
    }

    public void setIdHateword(int idHateword) {
        this.idHateword = idHateword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
