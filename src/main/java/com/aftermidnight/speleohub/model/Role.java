package com.aftermidnight.speleohub.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Role {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
	private String description;
    
    @ManyToMany
    @JoinTable(name = "role_privilege"
            , joinColumns = @JoinColumn(name = "role_id")
            , inverseJoinColumns = @JoinColumn(name = "privilege_id")
            , foreignKey =  @ForeignKey(name = "fk__role2role_privilege"))
    private Set<Privilege> privileges = new HashSet<>();
    
    
    public boolean removePrivilege(Privilege privilege) {
        return getPrivileges().remove(privilege);
    }

    public boolean addPrivilege(Privilege privilege) {
        return getPrivileges().add(privilege);
    }

    public boolean hasPrivilege(Long id){
        return getPrivileges().stream().anyMatch(p -> p.getId() == id);
    }

}