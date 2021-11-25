package com.fidesol.bcp.service.dtos;

public class ProjectData {

    private int id;
    private String name;
    private String url;
    private String descripcion;

    public ProjectData() {
    }

    public ProjectData(String name, String url, String descripcion) {
        this.name = name;
        this.url = url;
        this.descripcion = descripcion;
    }

    public ProjectData(int id, String name, String url, String descripcion) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
