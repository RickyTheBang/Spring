package broodjes.repository;

import broodjes.domain.Broodje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BroodjeRepository extends JpaRepository<Broodje, Integer> {

    default Broodje getBroodjeById(int id) {
        return findById (id).orElse (null);
    }

    default void updateBroodje(Broodje b) {
        save (b);
    }


    @Transactional
    @Query(value = "select b from Broodje b where b.name=?1")
    public Broodje getBroodjeByName(String typeName);



    @Transactional
    @Query(value = "select b from Broodje b")
    public List<Broodje> getAllBroodje();




    @Transactional
    @Modifying
    @Query(name ="Broodje_delete")
    public void deleteAllBroodje();


}