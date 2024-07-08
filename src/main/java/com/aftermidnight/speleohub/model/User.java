package com.aftermidnight.speleohub.model;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
    
    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime registerDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime")
    private OffsetDateTime lastAccess;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false)
    private boolean validated;

   /*  @Enumerated(EnumType.STRING)
    private Type type; */
    @Builder.Default
    @ManyToMany
    @JoinTable(name = "user_role"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id")
            , foreignKey =  @ForeignKey(name = "fk__user2user_role"))
    private Set<Role> roles = new HashSet<>();
    
    
    public boolean matchPasswordWith(String password) {
        return getPassword().equals(password);
    }

    public boolean notMatchPassordWith(String password) {
        return !matchPasswordWith(password);
    }
    
    public boolean removeRole(Role role) {
        return getRoles().remove(role);
    }

    public boolean addRole(Role role) {
        return getRoles().add(role);
    }


}

