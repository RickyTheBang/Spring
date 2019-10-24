package beers.repository;

import beers.domain.Beer;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class BeerRepositoryTest {
    @Autowired
    private BeerRepository repo;

    @BeforeTransaction
    public void beforeTransaction(){
        System.out.println("Before TX");
    }

    @AfterTransaction
    public void afterransaction(){
        System.out.println("After TX");
    }

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
    @Commit
    @DirtiesContext
    public void testUpdateBeer(){
        Beer beer = repo.getBeerById(1);
        int stock = beer.getStock();
        beer.setStock(stock-5);
        repo.updateBeer(beer);
        beer = repo.getBeerById(1);

        assertEquals(stock-5, beer.getStock());
    }
}
