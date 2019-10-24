package broodjes.service.implementation;

import broodjes.domain.Broodje;
import broodjes.domain.Ingredient;
import broodjes.repository.BroodjeRepository;
import broodjes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("broodjeService")
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    BroodjeRepository broodjeRepository;
    @Override
    public Broodje prepareBroodje(String name, Set<Ingredient> ingredients) {
        Broodje broodje = new Broodje (name,ingredients);
        broodjeRepository.updateBroodje (broodje);

        return broodje;

    }
}
