package fr.wijin.fiche.fiche.form;

import java.util.List;

import fr.wijin.fiche.fiche.model.enums.Grants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserForm {

    @NotNull
    @Size(min = 2, max = 20)
    private String username;

    @NotNull
    @Size(min = 2, max = 250)
    private String password;

    @NotNull
    private List<Grants> grants;

    public UserForm() {
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
