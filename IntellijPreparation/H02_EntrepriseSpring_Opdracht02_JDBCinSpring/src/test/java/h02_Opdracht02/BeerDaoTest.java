package h02_Opdracht02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import h02_Opdracht02.dao.BeerDao;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeerDaoTest {
	@Autowired
	private BeerDao dao;
	
	@Test
	public void testGetBeerById() {
		String beer = dao.getBeerById(1);
		Assertions.assertEquals("TestBeer 7.0 2.75 100", beer);
	}

	@Test
	public void testSetStock() {
		dao.setStock(1,20);
		String beer = dao.getBeerById(1);
		Assertions.assertEquals("TestBeer 7.0 2.75 20", beer);
		dao.setStock(1,100);
	}

	@Test
	public void testGetBeerByAlcohool() {
		List<String> beers = dao.getBeerByAlcohool(7);
		List<String> beersAssert = new ArrayList<>();
		beersAssert.add("TestBeer");

		Assertions.assertEquals(beersAssert, beers);

	}
	

}
