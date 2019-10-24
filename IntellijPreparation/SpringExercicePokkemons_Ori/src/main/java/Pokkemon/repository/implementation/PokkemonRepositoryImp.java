package Pokkemon.repository.implementation;

import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import Pokkemon.repository.PokkemonRepository;
import Pokkemon.repository.PokkemonTypeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository("pokkemonRepository")
@Primary
public class PokkemonRepositoryImp implements PokkemonRepository {
    private EntityManagerFactory emf;


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
    public void createPokkemon(Pokkemon pokemon) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(pokemon);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    @Bean("pokkemonList")
    public List<Pokkemon> getListPokkemons() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Pokkemon> pokkemonList= null;
        try {
            tx.begin();
            String sqlScript = "select p from Pokkemon as p";
            TypedQuery<Pokkemon> query=
            em.createQuery(sqlScript,Pokkemon.class);
            pokkemonList =query.getResultList();
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return pokkemonList;
    }


}




