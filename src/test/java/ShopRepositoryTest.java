import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(12, "Butter", 180);
    Product product2 = new Product(15, "Meet", 560);


    @Test
    public void ShouldRemoveIdError(){
        ShopRepository test = new ShopRepository();

        test.add(product1);

        Assertions.assertThrows(NotFoundException.class, () ->{
           test.remove(10);
        });
    }

    @Test
    public void ShouldRemoveId(){
        ShopRepository test = new ShopRepository();

        test.add(product1);
        test.add(product2);
        test.remove(12);

        Product[] expected = {product2};
        Product[] actual = test.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
