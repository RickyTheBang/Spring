package Pokkemon.repository.implementation;

import Pokkemon.model.Pokkemon;
import Pokkemon.repository.PokkemonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository("pokkemonRepository")
@Scope("prototype")
@Primary

public class PokkemonRepositoryImp implements PokkemonRepository {

    private   EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Pokkemon getPokkemonbyId(int id) {
        EntityManager em = emf.createEntityManager();



        EntityTransaction tx = em.getTransaction();
        Pokkemon pokkemon = null;
        try {
            tx.begin();
            pokkemon = em.find(Pokkemon.class, id);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pokkemon;
    }

    @Override
    public void savePokkemon(Pokkemon pokemon) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        if(pokemon!=null) {

            tx.begin ( );
            em.persist (pokemon);
            tx.commit ( );

        }

    }

    @Override
    //@Bean("pokkemonList")
    public List<Pokkemon> getAllPokkemons() {
        EntityManager em = emf.createEntityManager();

        List<Pokkemon> pokkemonList= null;


            String sqlScript = "select p from Pokkemon as p"; // Het is een jpql query. Dus de naam wordt veranderd als de entity name gewijzigd is.
            TypedQuery<Pokkemon> query=
            em.createQuery(sqlScript, Pokkemon.class);
            pokkemonList =query.getResultList();





        return pokkemonList;
    }


}




