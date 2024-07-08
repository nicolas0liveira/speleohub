package com.aftermidnight.speleohub.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CrudService<T> {
    public T save(T elem);
    public T getOneOrFail(Long id);
    public List<T> getAll();
    public void delete(Long id);
}
