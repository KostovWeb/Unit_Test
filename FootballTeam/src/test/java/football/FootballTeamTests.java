package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private Footballer footballer;
    private FootballTeam footballTeam;

    @Before
    public void setUp(){
        this.footballer = new Footballer("Ivan");
        this.footballTeam = new FootballTeam("Levski",12);

    }
    @Test
    public void testPositionTeam(){
        Assert.assertEquals(12,footballTeam.getVacantPositions());
    }@Test(expected = IllegalArgumentException.class)
    public void testPozishanTeamNot(){
        FootballTeam footballTeam = new FootballTeam("CSKA",-1);
    }
    @Test(expected = NullPointerException.class)
    public void testNameOfNull(){
        FootballTeam Arsenal = new FootballTeam(null,12);
    }@Test(expected = NullPointerException.class)
    public void testNameOfEmpty() {
        FootballTeam Arsenal = new FootballTeam("  ", 12);
    }@Test
    public void testNameOk(){
        FootballTeam footballTeam = new FootballTeam("CSKA",12);
        Assert.assertEquals("CSKA",footballTeam.getName());
    }@Test
    public void testAddFutballerOk(){
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1,footballTeam.getCount());
    }@Test(expected = IllegalArgumentException.class)
    public void testAddFutbollerNoPosition(){
        FootballTeam footballTeam1 = new FootballTeam("Litex",0);
        footballTeam1.addFootballer(footballer);
    }@Test
    public void testFutbollerRemovOk(){
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer(footballer.getName());
        Assert.assertEquals(0,footballTeam.getCount());
    }@Test(expected = IllegalArgumentException.class)
    public void testFutballerRemovNull() {
        Footballer footballer2 = new Footballer("Georgi");
        footballTeam.addFootballer(footballer);
        footballTeam.removeFootballer(footballer2.getName());
    }@Test
    public void testFutballerSaleOk(){
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer.getName());
        Assert.assertFalse(footballer.isActive());
    }@Test(expected = IllegalArgumentException.class)
    public void testFutballerSaleNull() {
        Footballer footballer2 = new Footballer("Georgi");
        footballTeam.addFootballer(footballer);
        footballTeam.footballerForSale(footballer2.getName());
    }
}
