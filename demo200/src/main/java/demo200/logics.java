package demo200;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import antlr.collections.List;







public class logics {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("movie");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void addMovie(add_movie addmovie)
	{
		transaction.begin();
		manager.persist(addmovie);
		transaction.commit();
	}
	public add_movie fetchStudent(String mname) {
		add_movie s = manager.find(add_movie.class, mname);
		return s;
	}
	

}
