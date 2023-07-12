package com.camelstudio.myapp.repository.extended;

import com.camelstudio.myapp.repository.MovieRepository;
import com.camelstudio.myapp.repository.MovieRepositoryWithBagRelationships;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositoryExtended extends MovieRepositoryWithBagRelationships, MovieRepository {}
