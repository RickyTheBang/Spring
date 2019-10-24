package Pokkemon.repository;

import Pokkemon.model.Pokkemon;
import Pokkemon.model.PokkemonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;

public interface PokkemonTypeRepository extends JpaRepository<PokkemonType,Integer> {
    default PokkemonType getPokkemonByTypeId(int id) {
        return findById(id).orElse(null);
    }

    @Transactional
    @Query(value = "select pt from PokkemonType  pt where pt.typeName=?1")
    public PokkemonType getPokkemonByTypeName(String typeName);

    default void savePokkemonType(PokkemonType pokemonType) {

       save(pokemonType);
    }



    @Transactional
    @Modifying
    @Query(name ="PokkemonType_delete")
    public void deleteAllPokkemonType();








}
