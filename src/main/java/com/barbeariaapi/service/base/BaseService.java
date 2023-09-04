package com.barbeariaapi.service.base;

import java.util.List;

public interface BaseService<T> {
    List<T> listAll();

    T getById(Long id);

    T saveOrUpdate(T domainObject);

    void delete(Long id);
}