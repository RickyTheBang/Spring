package Pokkemon.repository;

import Pokkemon.model.Pokkemon;

import java.util.List;

public interface PokkemonRepository {
    public Pokkemon getPokkemonbyId(int id);
    public void savePokkemon(Pokkemon pokkemon);
    public List<Pokkemon> getAllPokkemons();


}
