package com.pruebatecnica.dropwizard.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.pruebatecnica.dropwizard.data.Movie;
import com.pruebatecnica.dropwizard.persistence.MovieDB;

@Path("/movie")
public class MovieService {
	
	@GET
	@Timed
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Movie getMovie(@PathParam("id") int id) {
		return MovieDB.getById(id);
	}
	
	@GET
	@Timed
	@Path("/remove")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeMovie() {
		MovieDB.remove();
		return "Ultima pelicula borrada. Total: " + MovieDB.getCount();
	}
	
	@GET
	@Timed
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies(){
		return MovieDB.getAll();
	}
	
	@POST
	@Timed
	@Path("/save")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String addMovie(Movie movie) {
		return MovieDB.save(movie);
	}
}
