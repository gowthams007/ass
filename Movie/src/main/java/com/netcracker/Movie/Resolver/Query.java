package com.netcracker.Movie.Resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.netcracker.Movie.Model.Director;
import com.netcracker.Movie.Model.Movie;
import com.netcracker.Movie.Repository.DirectorRepository;
import com.netcracker.Movie.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Query implements GraphQLQueryResolver {
    private DirectorRepository directorRepository;
    private MovieRepository movieRepository;

     @Autowired
    public Query(DirectorRepository directorRepository,MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;

    }
    public Iterable<Movie> findAllMovies() {
            return movieRepository.findAll();
    }

    public Iterable<Director> findAllDirector() {
            return directorRepository.findAll();
    }


}
