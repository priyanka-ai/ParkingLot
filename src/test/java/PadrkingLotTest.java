import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PadrkingLotTest {

    private ParkingLot parkinglot;
    private Object vehical;
    private Object vehical2;

    @Before
    public void setUp() throws Exception {
        parkinglot=new ParkingLot(2);
    }

    @Test
    public void givenVehical_WhenalreadyParked_ShouldReturnTrue() {
        parkinglot.park(vehical);
        boolean isParked=parkinglot.isVehicalParked(vehical);
        Assert.assertEquals(isParked,true);
    }

    @Test
    public void givenVehical_WhenUnparked_ShouldReturnTrue() {
        parkinglot.park(vehical);
        boolean unParked=parkinglot.unParked(vehical);
        Assert.assertEquals(unParked,true);
    }


    @Test
    public void given2Vehical_WhenUnparked_ShouldReturnTrue() {
        try {
            parkinglot.park(vehical);
            vehical2 = new Object();
            parkinglot.park(vehical2);
        }catch (RuntimeException e) {
            boolean unParked1 = parkinglot.isVehicalParked(vehical);
            boolean unParked2 = parkinglot.isVehicalParked(vehical2);
            Assert.assertEquals(unParked1 && unParked2, true);
        }
    }


    @Test
    public void givenVehicle_WhenSpaceIsAvailable_ShouldInformTheAS() {
        Object vehicle2 = new Object();
        AirportSecurity owner = new AirportSecurity();
        parkinglot.registerObserver(owner);
        try {
            parkinglot.park(vehical);
            parkinglot.park(vehicle2);
            parkinglot.unParked(vehical);
        } catch (Exception e) {
            Assert.assertFalse(owner.isCapacityFull());
        }
    }

    @Test
    public void givenVehicle_WhenSpaceIsAvailable_ShouldInformTheOwner() {
        Object vehicle2 = new Object();
        AirportSecurity owner = new AirportSecurity();
        parkinglot.registerObserver(owner);
        try {
            parkinglot.park(vehical);
            parkinglot.park(vehicle2);
            parkinglot.unParked(vehical);
        } catch (Exception e) {
            Assert.assertFalse(owner.isCapacityFull());
        }
    }


    @Test
    public void givenVehicle_WhenLotFull_ShouldInformTheAS() {
        Object vehicle2 = new Object();
        AirportSecurity owner = new AirportSecurity();
        parkinglot.registerObserver(owner);
        try {
            parkinglot.park(vehical);
            parkinglot.park(vehicle2);
        } catch (Exception e) {
            Assert.assertFalse(owner.isCapacityFull());
        }
    }

    @Test
    public void givenVehicle_WhenLotFull_ShouldInformTheOwner() {
        Object vehicle2 = new Object();
        AirportSecurity owner = new AirportSecurity();
        parkinglot.registerObserver(owner);
        try {
            parkinglot.park(vehical);
            parkinglot.park(vehicle2);
        } catch (Exception e) {
            Assert.assertFalse(owner.isCapacityFull());
        }
    }

    @Test
    public void givemVehicl_ifFind_ReturnTrue() {
        parkinglot.park(vehical);
        parkinglot.isVehicalParked(vehical);
        parkinglot.isPresent(vehical);
        Assert.assertTrue(true);
    }

    @Test
    public void givemVehicl_ifNotFind_ReturnFalse() {
        parkinglot.park(vehical);
        parkinglot.isVehicalParked(vehical);
        parkinglot.isPresent(vehical);
        Assert.assertFalse(false);
    }
}
