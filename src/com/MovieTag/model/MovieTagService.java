package com.MovieTag.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class MovieTagService {

	private MovieTagDAO_interface dao;

	public MovieTagService() {
		dao = new MovieTagJDBCDAO();
	}

	public MovieTagVO addMovieTag(Integer movieId, Integer genreId) {

		MovieTagVO movieTagVO = new MovieTagVO();

		
		movieTagVO.setMovieId(movieId);
		movieTagVO.setGenreId(genreId);
		dao.insert(movieTagVO);

		return movieTagVO;
	}

	public MovieTagVO updateMovie(Integer tagId, Integer movieId, Integer genreId) {

		MovieTagVO movieTagVO = new MovieTagVO();

		movieTagVO.setTagId(tagId);
		movieTagVO.setMovieId(movieId);
		movieTagVO.setGenreId(genreId);
		dao.update(movieTagVO);

		return movieTagVO;
	}

	public void deleteMovie(Integer tagId) {
		dao.delete(tagId);
	}

	public MovieTagVO getOneMovieTag(Integer movieId) {
		return dao.findByMovieId(movieId);
	}

	public List<MovieTagVO> getAll() {
		return dao.getAll();
	}
}
