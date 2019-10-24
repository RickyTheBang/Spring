package h02_Opdracht02.dao.impl;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import h02_Opdracht02.dao.BeerDao;

import java.util.List;
import h02_Opdracht02.model.Beer;


@Repository(value = "beerDao")
public class BeearDaoImpl implements BeerDao {
	private final static String QUERY_ID = 
			"SELECT Name, Alcohol, Price, Stock FROM  Beers  WHERE Id=?";
	private final static String UPDATE_STOCK =
			"UPDATE Beers SET Stock = ? WHERE Id=?";
	private final static String CREATE ="INSERT INTO Beers (Name, BrewerId,CategoryId,Price,Stock,Alcohol,Version) value (?,1,1,?,?,?,2)";
	
	

	
	private final static String SELECTBYALCOHOOL ="select Name from Beers where Alcohol = ?";
	
	private JdbcTemplate template;
	
	
	
	
	@Autowired
	public void SetJdbcTemplate (JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public String getBeerById(int id) {
		Map<String, Object> result = 
				template.queryForMap(QUERY_ID,id);
				
		return String.format("%s %s %s %s", 
				result.get("name"),
				result.get("alcohol"),
				result.get("price"),
				result.get("stock"));
		
	}

	@Override
	public void setStock(int id, int stock) {
		template.update(UPDATE_STOCK,stock,id);
		
	}



	@Override
	public List<String> getBeerByAlcohool(float alcohool) {
		
		
		List<String> beers = template.queryForList(SELECTBYALCOHOOL,String.class,alcohool);
		
		

		
		return beers;
	}
	
}
	