package com.netcracker.Movie.Repository;

import com.netcracker.Movie.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface DirectorRepository extends JpaRepository<Director,Long>{

}
