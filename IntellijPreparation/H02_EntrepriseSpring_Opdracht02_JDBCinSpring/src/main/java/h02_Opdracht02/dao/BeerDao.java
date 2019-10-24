package h02_Opdracht02.dao;

import java.util.List;

import h02_Opdracht02.model.Beer;

public interface BeerDao {
	public String getBeerById(int id);
	public void setStock(int id, int stock);
	public List<String> getBeerByAlcohool(float alcohool);
	
	

}
