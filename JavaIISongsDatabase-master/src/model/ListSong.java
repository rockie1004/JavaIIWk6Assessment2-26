package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="songs")
public class ListSong {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	
private int id;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) 
 	@JoinColumn(name="artist_id")
	private ListArtist artist;
@Column(name="title")
private String title;

public ListSong() {}


/**
 * @param artist
 * @param title
 */
public ListSong(ListArtist artist, String title) {
	this.artist = artist;
	this.title = title;
}

/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the artist
 */
public ListArtist getArtist() {
	return artist;
}
/**
 * @param artist the artist to set
 */
public void setArtist(ListArtist artist) {
	this.artist = artist;
}
/**
 * @return the title
 */
public String getTitle() {
	return title;
}
/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}

public String toString() {
	return title + " by " + artist.getArtistName();
}




}
