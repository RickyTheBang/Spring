package Pokkemon.repository.implementation;

import Pokkemon.model.PokkemonType;
import Pokkemon.repository.PokkemonTypeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository("pokkemonTypeRepository")
public class PokkemonTypeRepositoryImp implements PokkemonTypeRepository {
    private EntityManagerFactory emf;


    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public PokkemonType getPokkemonbyTypeId(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        PokkemonType pokkemonType = null;
        try {
            tx.begin();
            pokkemonType = em.find(PokkemonType.class, id);
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return pokkemonType;
    }

    @Override
    public void createPokkemonType(PokkemonType pokemonType) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(pokemonType);
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


}




