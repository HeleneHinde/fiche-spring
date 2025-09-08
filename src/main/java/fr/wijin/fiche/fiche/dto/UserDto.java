package fr.wijin.fiche.fiche.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import fr.wijin.fiche.fiche.model.enums.Grants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {
    
    private static final long serialVersionUID = -66248L;

    private Long id;

    
    private String username;

    private String password;

    private List<Grants> grants;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Grants> getGrants() {
        return grants;
    }
    public void setGrants(List<Grants> grants) {
        this.grants = grants;
    }
}
