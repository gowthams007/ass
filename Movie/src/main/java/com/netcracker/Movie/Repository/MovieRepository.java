package com.netcracker.Movie.Repository;

import com.netcracker.Movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface MovieRepository extends JpaRepository<Movie,Long> {
}
