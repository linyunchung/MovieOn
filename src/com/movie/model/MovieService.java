package com.movie.model;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

public class MovieService {

	private MovieDAO_interface dao;

	public MovieService() {
		dao = new MovieJDBCDAO();
	}

	public MovieVO addMovie(String movieName, String movieEName, java.sql.Date releaseDate,
			Integer mins, String studio, String plot, byte[] poster, String actor, String director, String movieTag) {

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
		movieVO.setMovieTag(movieTag);
		dao.insert(movieVO);

		return movieVO;
	}

	public MovieVO updateMovie(Integer movieId, String movieName, String movieEName, java.sql.Date releaseDate,
			Integer mins, String studio, String plot, byte[] poster, String actor, String director, String movieTag) {

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
		movieVO.setMovieTag(movieTag);
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
	public List<MovieVO> getAllByMovieName(String movieName) {
		return dao.getAllByMovieName(movieName);
	}
}
