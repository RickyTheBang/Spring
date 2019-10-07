package Pokkemon.repository;

import Pokkemon.model.PokkemonType;

public interface PokkemonRepository {
   // public PokemonType getPokkemonbyTypeName(String typeName);

    public void createPokkemonType(PokkemonType pokkemonType);

}
