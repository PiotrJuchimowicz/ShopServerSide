package com.company.dishes.service;

public interface BaseService<D, T> {

    D read(T id);
}
