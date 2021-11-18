package com.project.GamerSpaceServer.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol {
    @Id
    @GeneratedValue
    Long rolId;
    
    private String rol;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
    private List<UserGS> users;

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
