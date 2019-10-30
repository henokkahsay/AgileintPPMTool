package com.henok.ppmtool.repositories;

import com.henok.ppmtool.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository <Backlog, Long> {

}
