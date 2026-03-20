package com.cg.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="abes_track")
public class Track {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "track_id")
	private Integer trackId;
	
	@Column(name = "track_title")
	private String trackTitle;
	
	@Column(name = "album_name")
	private String albumName;
	
	@Column(name = "release_dt")
	private LocalDate releaseDt;

	public Integer getTrackId() {
		return trackId;
	}

	public void setTrackId(Integer trackId) {
		this.trackId = trackId;
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public LocalDate getReleaseDt() {
		return releaseDt;
	}

	public void setReleaseDt(LocalDate releaseDt) {
		this.releaseDt = releaseDt;
	}

	@Override
	public String toString() {
		return "Track [ "+ 
				"trackId = " + trackId + 
				", trackTitle = " + trackTitle + 
				", albumName = " + albumName + 
				", releaseDt = " + releaseDt + 
				" ]";
	}
	
	

}
