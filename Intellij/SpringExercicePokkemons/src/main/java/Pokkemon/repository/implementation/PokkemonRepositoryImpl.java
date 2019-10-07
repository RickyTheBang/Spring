package Pokkemon.repository.implementation;

import Pokkemon.model.PokkemonType;
import Pokkemon.repository.PokkemonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Repository("pokkemonRepository")
public class PokkemonRepositoryImpl implements PokkemonRepository {
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void createPokkemonType(PokkemonType pokemonType) {
        EntityManager em = emf.createEntityManager ( );
        EntityTransaction tx = em.getTransaction ( );
        pokemonType.setBaseAttack (10);
        pokemonType.setBaseDefense (20);
        pokemonType.setBaseHitPoints (50);
        pokemonType.setBeschrijving ("Heavy");
        pokemonType.setTypeName ("Diglet");
        try {
            tx.begin ( );
            em.persist (pokemonType);
            tx.commit ( );
        } catch (Exception e) {
            tx.rollback ( );
            throw e;
        }
}


}




