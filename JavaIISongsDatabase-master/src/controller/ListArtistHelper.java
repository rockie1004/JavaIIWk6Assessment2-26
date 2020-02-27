package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListArtist;

public class ListArtistHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persistfile");

public void insertArtist(ListArtist li) {
	//
	String artistEntered = li.getArtistName();
	System.out.println("test inside lah.insertArtist :"+artistEntered);
	
	List<ListArtist> matchArtists = searchForArtistByName(artistEntered);
	if(matchArtists.isEmpty()) {//if no match, add new artist to the database then get that entry from the database so we know the id.
		//insert if not already existing
		EntityManager em=emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
};

public	List<ListArtist>	showAllArtists(){
EntityManager	em	=	emfactory.createEntityManager();
@SuppressWarnings("unchecked")
List<ListArtist>	allArtists	=	em.createQuery("SELECT i FROM ListArtist i").getResultList();
return	allArtists;
}

public	void	deleteArtist(ListArtist	toDelete)	{
EntityManager	em	=	emfactory.createEntityManager();
em.getTransaction().begin();
TypedQuery<ListArtist>	typedQuery	= em.createQuery("select li	from ListArtist	li	where li.artistName	=	:selectedArtistName",	ListArtist.class);

//Substitute	parameter	with	actual	data	from	the	toDelete	Artist
typedQuery.setParameter("selectedArtistName",	toDelete.getArtistName());

//we	only	want	one	result
typedQuery.setMaxResults(1);

//get	the	result	and	save	it	into	a	new	listArtist
//ADDED check if any result

try 
	{
	ListArtist	result	=	typedQuery.getSingleResult();

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
public ListArtist searchForArtistById(int idToEdit) {
	EntityManager	em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	ListArtist	found	=	em.find(ListArtist.class,	idToEdit);
	em.close();
	return	found;	
}

public void updateArtist(ListArtist toEdit) {
	EntityManager	em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();	
}

public List<ListArtist> searchForArtistByName(String artistName) {
	EntityManager em	=	emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<ListArtist>	typedQuery	=	em.createQuery("select	li	from ListArtist	li	where	li.artistName	=	:selectedArtistName",	ListArtist.class);
	typedQuery.setParameter("selectedArtistName", artistName);
	List<ListArtist>	foundArtists	=	typedQuery.getResultList();
	em.close();
	return	foundArtists;
}

public	void	cleanUp(){
emfactory.close();
}
}
