package fr.wijin.fiche.fiche.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.wijin.fiche.fiche.model.User;
import fr.wijin.fiche.fiche.model.enums.Grants;

public class MonUserDetails implements UserDetails {

    private final User user;

    public MonUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        List<GrantedAuthority> listGrants = new ArrayList<>();
        if (user != null && user.getGrants() != null) {
            for (Grants grant : user.getGrants()) {
                listGrants.add(new SimpleGrantedAuthority(grant.name()));
            }
        }
        return listGrants;
    }

    @Override
    public String getPassword() {
        return user != null ? user.getPassword() : null;
    }

    @Override
    public String getUsername() {
        return user != null ? user.getUsername() : null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
