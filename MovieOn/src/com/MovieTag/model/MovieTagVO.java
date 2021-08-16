package com.MovieTag.model;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class MovieTagVO implements java.io.Serializable{
	private Integer tagId;
	private Integer movieId;
	private Integer genreId;
	
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	

}
