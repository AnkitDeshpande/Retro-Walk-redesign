package com.retrowalk.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role extends AuditCommonBaseModel implements GrantedAuthority {

    /**
     * Role name, must be unique and not null.
     */
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    /**
     * Description of the role.
     */
    @Column(name = "description", length = 255)
    private String description;

    /**
     * This flag is true if the role is generated dynamically for ACL security purposes.
     */
    @Column(name = "is_dynamic", nullable = false)
    private boolean isDynamic;

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
