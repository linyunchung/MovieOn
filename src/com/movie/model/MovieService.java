package com.movie.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class MovieService {

	private MovieDAO_interface dao;

	public MovieService() {
		dao = new MovieJDBCDAO();
	}

	public MovieVO addMovie(String movieName, String movieEName, java.sql.Date releaseDate,
			int mins, String studio, String plot, Blob poster, String actor, String director) {

		MovieVO movieVO = new MovieVO();

		movieVO.setMovieName(movieName);
		movieVO.setMovieEName(movieEName);
		movieVO.setReleaseDate(releaseDate);
		movieVO.setMins(mins);
		movieVO.setStudio(studio);
		movieVO.setPlot(plot);
		movieVO.setPoster(poster);
		movieVO.setActor(actor);
		movieVO.setDirector(director);
		dao.insert(movieVO);

		return movieVO;
	}

	public MovieVO updateMovie(Integer movieId, String movieName, String movieEName, java.sql.Date releaseDate,
			int mins, String studio, String plot, Blob poster, String actor, String director) {

		MovieVO movieVO = new MovieVO();

		movieVO.setMovieId(movieId);
		movieVO.setMovieName(movieName);
		movieVO.setMovieEName(movieEName);
		movieVO.setReleaseDate(releaseDate);
		movieVO.setMins(mins);
		movieVO.setStudio(studio);
		movieVO.setPlot(plot);
		movieVO.setPoster(poster);
		movieVO.setActor(actor);
		movieVO.setDirector(director);
		dao.update(movieVO);

		return movieVO;
	}

	public void deleteMovie(Integer movieId) {
		dao.delete(movieId);
	}

	public MovieVO getOneMovie(Integer movieId) {
		return dao.findByPrimaryKey(movieId);
	}

	public List<MovieVO> getAll() {
		return dao.getAll();
	}
}
