package beers.repository;

import beers.domain.Beer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BeerRepositoryTest {
    @Autowired
    private BeerRepository repo;

    @Test
    public void testGetBeerById(){
        Beer beer = repo.getBeerById(1);
        assertEquals("TestBeer", beer.getName());
    }

/*	@Test
	public void testGetBeerByAlcohool() {
		List<Beer> beers = repo.getBeerByAlcohol(7);
		Beer beerID1 = repo.getBeerById(1);
		List<Beer> beersAssert = new ArrayList<>();
		beersAssert.add(beerID1);

		Assertions.assertEquals(beersAssert, beers);

	}*/

    @Test
    public void testUpdateBeer(){
        Beer beer = repo.getBeerById(1);
        int stock = beer.getStock();
        beer.setStock(stock-5);
        repo.updateBeer(beer);
        beer = repo.getBeerById(1);

        assertEquals(stock-5, beer.getStock());
    }
}
