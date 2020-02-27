package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListSong;

public class ListSongHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistfile");

public void insertSong(ListSong li) {
	EntityManager em=emfactory.createEntityManager();
	em.getTransaction().begin();
	em.persist(li);
	em.getTransaction().commit();
	em.close();
	
};

public	List<ListSong>	showAllSongs(){
EntityManager	em	=	emfactory.createEntityManager();
@SuppressWarnings("unchecked")
List<ListSong>	allSongs	=	em.createQuery("SELECT i FROM ListSong i").getResultList();
return	allSongs;
}

public	void	deleteSong(ListSong	toDelete)	{
EntityManager	em	=	emfactory.createEntityManager();
em.getTransaction().begin();
TypedQuery<ListSong>	typedQuery	=	em.createQuery("select	li	from ListSong	li	where	li.artist	=	:selectedArtist	and	li.title	=	:selectedTitle",	ListSong.class);

//Substitute	parameter	with	actual	data	from	the	toDelete	Song
typedQuery.setParameter("selectedArtist",	toDelete.getArtist());
typedQuery.setParameter("selectedTitle",	toDelete.getTitle());

//we	only	want	one	result
typedQuery.setMaxResults(1);

//get	the	result	and	save	it	into	a	new	list	Song
//ADDED check if any result

try 
	{
	ListSong	result	=	typedQuery.getSingleResult();

	//remove	it
	em.remove(result);
	em.getTransaction().commit();
	em.close();
	}
catch (NoResultException none) 
	{
	System.out.println("No matching entry was found.");
	return;
}

}
public ListSong searchForSongById(int idToEdit) {
	EntityManager	em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	ListSong	found	=	em.find(ListSong.class,	idToEdit);
	em.close();
	return	found;	
}
public void updateSong(ListSong toEdit) {
	EntityManager	em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();	
}
/*
public List<ListSong> searchForSongByArtist(String artistName) {
	EntityManager	em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListSong>	typedQuery	=	em.createQuery("select	so	from	ListSong	INNER JOIN ListArtist AS ar where	ar.artistName = :selectedArtist",	ListSong.class);
	typedQuery.setParameter("selectedArtist",	artistName);
	List<ListSong>	foundSongs	=	typedQuery.getResultList();
	em.close();
	return	foundSongs;
}
*/
public List<ListSong> searchForSongByTitle(String title) {
	EntityManager em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListSong>	typedQuery	=	em.createQuery("select	li	from ListSong	li	where	li.title	=	:selectedTitle",	ListSong.class);
	typedQuery.setParameter("selectedTitle",	title);
	List<ListSong>	foundSongs	=	typedQuery.getResultList();
	em.close();
	return	foundSongs;
}

public	void	cleanUp(){
emfactory.close();
}
}
