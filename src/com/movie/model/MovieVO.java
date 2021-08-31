package com.movie.model;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Time;

public class MovieVO implements java.io.Serializable {
	private Integer movieId;
	private String movieName;
	private String movieEName;
	private Date releaseDate;
	private Integer mins;
	private String studio;
	private String plot;
	private byte[] poster;
	private String actor;
	private String director;
	private String movieTag;


	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieEName() {
		return movieEName;
	}

	public void setMovieEName(String movieEName) {
		this.movieEName = movieEName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getMins() {
		return mins;
	}

	public void setMins(Integer time) {
		this.mins = time;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}
	/*
	public Blob getPoster() {
		return poster;
	}
	*/
	
	public byte[] getPoster() {
		return poster;
	}
	
	/*
	public void setPoster(Blob bs) {
		this.poster=bs;
	}
	*/
	
	public void setPoster(byte[] bs) {
		this.poster = bs;
	}
	
	
	public String getActor() {
		return actor;
	}
	
	
	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMovieTag() {
		return movieTag;
	}

	public void setMovieTag(String movieTag) {
		this.movieTag = movieTag;
	}

}