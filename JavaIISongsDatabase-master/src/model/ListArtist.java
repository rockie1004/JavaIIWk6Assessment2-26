package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="artists")
public class ListArtist {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@Column(name="artist_id")
private int id;
	
@Column(name="artist_name")
private String artistName;

public ListArtist() {}
/**
 * @param artistName
 */
public ListArtist(String artistName) {
	this.artistName = artistName;
}
/**
 * @param artistId
 * @param artistName
 */
public ListArtist(int id, String artistName) {
	this.id = id;
	this.artistName = artistName;
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
 * @return the artistName
 */
public String getArtistName() {
	return artistName;
}
/**
 * @param artistName the artistName to set
 */
public void setArtistName(String artistName) {
	this.artistName = artistName;
}

public String toString() {
	return artistName;
}





}
