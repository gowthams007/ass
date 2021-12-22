package com.netcracker.Movie.Resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.netcracker.Movie.Model.Director;
import com.netcracker.Movie.Model.Movie;
import com.netcracker.Movie.Repository.DirectorRepository;
import com.netcracker.Movie.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;


public class Mutation implements GraphQLMutationResolver {
    private DirectorRepository directorRepository;
    private MovieRepository movieRepository;
    @Autowired
    public Mutation(DirectorRepository directorRepository, MovieRepository movieRepository) {
        this.directorRepository = directorRepository;
        this.movieRepository = movieRepository;
    }

    public Director createDirector(String name, String gender, Integer totalMovies) {
        Director director = new Director();
        director.setName(name);
        director.setGender(gender);
        director.setTotalMovies(totalMovies);
        directorRepository.save(director);

        return director;
    }

    public Movie createMovie(String name, String releaseDate, float imdbRating, Long id) {
        Movie movie = new Movie();
        movie.setMoviename(name);
        movie.setReleasedate(releaseDate);
        movie.setImdbRating(imdbRating);
        movie.setDirector(new Director(id));

        movieRepository.save(movie);

        return movie;
    }

    public boolean deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return true;
    }

    public Movie updateMovie(Long id, String name, String releaseDate, Float imdbRating) {
        Optional<Movie> omovie = movieRepository.findById(id);

        if (omovie.isPresent()) {
            Movie movie = omovie.get();

            if (name != null)
                movie.setMoviename(name);
            movie.setReleasedate(releaseDate);
            movie.setImdbRating(imdbRating);
            movieRepository.save(movie);
            return movie;
        }
      return null;

    }
}
