package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class FarmvilleTests {
    private Animal caw;
    private Animal dog;
    private Farm echevi;



    @Before
    public void setUp() {
        caw = new Animal("Cow", 15);
        dog = new Animal("Sara",10);
        echevi = new Farm("Echevi", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstruktorSetCapacityZero() {
        Farm farm1 = new Farm("Cow-Farm", -1);
    }

    @Test
    public void testConstruktorSetCapacityOK() {
        Farm farm1 = new Farm("Cow-Farm", 1);
        Assert.assertEquals(1, farm1.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testConstruktorsetNameNull() {
        Farm farm = new Farm(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testConstruktorsetNameEmpty() {
        Farm farm = new Farm("  ", 10);
    }

    @Test
    public void testConstruktorsetNameOK() {
        Assert.assertEquals("Echevi", this.echevi.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAnimalNoCapacity (){
        this.echevi.add(caw);
        this.echevi.add(caw);
    }

    @Test
    public void testAddAnimalOK(){
        Farm farm = new Farm("Levski",10);
        farm.add(caw);
        Assert.assertEquals(1,farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNoCapacity(){
        Farm farm = new Farm("Levski",1);
        farm.add(caw);
        farm.add(dog);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDubleAnimal(){
        Farm farm = new Farm("Levski",10);
        farm.add(dog);
        farm.add(dog);
    }

    @Test
    public void testRemuveOK(){
        Farm farm = new Farm("Levski",10);
        farm.add(caw);
        farm.add(dog);
        Assert.assertTrue(farm.remove("Sara"));

    }

    @Test
    public void testRemuveNo(){
        Farm farm = new Farm("Levski",10);
        farm.add(caw);
        farm.add(dog);
        Assert.assertFalse(farm.remove("Pesho"));
    }
}
