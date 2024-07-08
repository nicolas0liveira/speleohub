package com.aftermidnight.speleohub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aftermidnight.speleohub.model.User;
import com.aftermidnight.speleohub.repository.UserRepository;

@Service
public class UserService implements CrudService<User> {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public User save(User elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public User getOneOrFail(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOneOrFail'");
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


}
