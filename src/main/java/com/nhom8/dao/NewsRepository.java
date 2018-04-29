package com.nhom8.dao;

import org.springframework.data.repository.CrudRepository;

import com.nhom8.model.News;

public interface NewsRepository extends CrudRepository<News, Integer> {

}
