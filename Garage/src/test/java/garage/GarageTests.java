package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GarageTests {
    private Car car;
    private Car car2;
    private Garage garage;

    @Before
    public void setUp(){
        this.car = new Car("Mercedes",260,200000);
        this.car2 = new Car("Ww",150,100000);
        this.garage = new Garage();
    }
    @Test
    public void testAddCarOK(){
        garage.addCar(car);
        Assert.assertEquals(1,garage.getCount());
    }@Test(expected = IllegalArgumentException.class)
    public void testAddCarNull(){
        Car car1 = null;
        garage.addCar(car1);
    }@Test
    public void testGetCarsOK (){
        garage.addCar(car);
        garage.addCar(car2);
        Assert.assertEquals(2,garage.getCars().size());
    }@Test
    public void testFindAllCarsWithMaxSpeedAbove(){
        garage.addCar(car);
        garage.addCar(car2);
        int topCar = garage.findAllCarsWithMaxSpeedAbove(200).size();
        Assert.assertEquals(1,topCar);
    }@Test
    public void testGetTheMostExpensiveCar(){
        garage.addCar(car);
        garage.addCar(car2);
        Car carExpensive = garage.getTheMostExpensiveCar();
        double price = carExpensive.getPrice();
        double exPrice = 200000;
        Assert.assertEquals(exPrice, price, 0.001);
    }@Test
    public void testFindAllCarsByBrand(){
        garage.addCar(car);
        garage.addCar(car2);
        int carFind = garage.findAllCarsByBrand("Mercedes").size();
        Assert.assertEquals(1,carFind);

    }
}