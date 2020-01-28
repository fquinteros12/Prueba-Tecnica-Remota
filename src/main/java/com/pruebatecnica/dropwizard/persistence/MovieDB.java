package com.pruebatecnica.dropwizard.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.pruebatecnica.dropwizard.data.Movie;

public class MovieDB {
	private static final Map<Integer, Movie> MOVIES = new TreeMap<>();
	
	static {
		MOVIES.put(1, new Movie(1, "Relatos Salvajes", 2015, "Accion"));
		MOVIES.put(2, new Movie(2, "El secreto de sus Ojos", 2009, "Suspenso"));
		MOVIES.put(3, new Movie(3, "Un cuento chino", 2018, "Accion"));
	}
	
	public static Movie getById(int id) {
		return MOVIES.get(id);
	}
	
	public static List<Movie> getAll(){
		List<Movie> result = new ArrayList<Movie>();
		for (Integer key : MOVIES.keySet()) {
			result.add(MOVIES.get(key));
		}
		return result;
	}
	
	public static int getCount() {
		return MOVIES.size();
	}
	
	public static void remove() {
		if (!MOVIES.keySet().isEmpty()) {
			MOVIES.remove(MOVIES.keySet().toArray()[MOVIES.keySet().size() - 1]);
		}
	}
		
	public static String save(Movie movie) {
		String result = "";
		if (MOVIES.get(movie.getId()) != null) {
			result = "Se modifico la pelicula con el id=" + movie.getId();
		} else {
			result = "Se agrego persona con id=" + movie.getId();
		}
		MOVIES.put(movie.getId(), movie);
		return result;
	}
	}

