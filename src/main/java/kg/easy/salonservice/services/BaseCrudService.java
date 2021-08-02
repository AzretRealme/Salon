package kg.easy.salonservice.services;

import kg.easy.salonservice.exceptions.NotExistTime;

import java.util.List;

public interface BaseCrudService<S, T> {

    S save(S s);
    S update(S s);
    S findById(T id);
    List<S> findAll();
}