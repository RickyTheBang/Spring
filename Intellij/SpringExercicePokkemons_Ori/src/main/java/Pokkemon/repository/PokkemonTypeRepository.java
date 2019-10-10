package Pokkemon.repository;

import Pokkemon.model.PokkemonType;

public interface PokkemonTypeRepository {
    public PokkemonType getPokkemonbyTypeId(int id);

    public void createPokkemonType(PokkemonType pokkemonType);

}
