package com.aftermidnight.speleohub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aftermidnight.speleohub.model.Role;
import com.aftermidnight.speleohub.repository.RoleRepository;

@Service
public class RoleService implements CrudService<Role> {

    @Autowired
    private RoleRepository repo;

    public Role save(Role role) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Role getOneOrFail(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'getOneOrFail'");
    }

    public List<Role> getAll() {
        return repo.findAll();
    
    }

    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    
    public void assignPrivilege(Long groupId, Long... privilegeId) {
        throw new UnsupportedOperationException("Unimplemented method 'assignPrivilege'");
    }

    public void unassignPrivilege(Long groupId, Long... privilegeId) {
        throw new UnsupportedOperationException("Unimplemented method 'unassignPrivilege'");
    }

    public List<Role> byPrivilege(Long privilegeId) {
        throw new UnsupportedOperationException("Unimplemented method 'byPrivilege'");
    }
    

}
