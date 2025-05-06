package tp.tp1;

import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

@SpringBootTest
class Tp1ApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Dell",2200.500,new Date());
        produitRepository.save(prod);
    }

    @Autowired
    private ProduitService produitService;

    @Test
    public void testFindByNomProduitContains() {
        Page<Produit> prods = produitService.getAllProduitsParPage(0, 2);
        System.out.println(prods.getSize());
        System.out.println(prods.getTotalElements());
        System.out.println(prods.getTotalPages());
        prods.getContent().forEach(p -> {
            System.out.println(p.toString());
        });
    }
}