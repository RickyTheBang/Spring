package broodjes.service;

public interface BroodjeService {

    int orderBroodje(String name, int broodjeId, int number);
    int orderBroodjes(String name, int[][] order);
}

