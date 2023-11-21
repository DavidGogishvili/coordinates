package ge.davidgogishvili.projects.coordinates.Entities;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(schema = "public", name = "users")
public class User implements UserDetails {

    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="users_seq-generator")
    @SequenceGenerator(name="users_seq-generator", sequenceName="users_id_seq", allocationSize = 1)
    @Id
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column (name = "username")
    private String username;

    @Column (name = "name")
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "active")
    private Boolean active;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
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

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
