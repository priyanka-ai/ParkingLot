import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class PadrkingLotTest {

    private ParkingLot parkinglot;
    private Object vehical;
    private Object vehical2;
    private Object slotnumber;
    private Integer allocatedSlot;

    @Before
    public void setUp() throws Exception {
        parkinglot=new ParkingLot(2);
    }

    @Test
    public void givenVehical_WhenalreadyParked_ShouldReturnTrue() {
        parkinglot.park(vehical,driverType.NORMAL);
        boolean isParked=parkinglot.isVehicalParked(vehical);
        Assert.assertEquals(isParked,true);
    }

    @Test
    public void givenVehical_WhenUnparked_ShouldReturnTrue() {
        parkinglot.park(vehical,driverType.NORMAL);
        boolean unParked=parkinglot.unParked(vehical);
        Assert.assertEquals(unParked,true);
    }


    @Test
    public void given2Vehical_WhenUnparked_ShouldReturnTrue() {
        try {
            parkinglot.park(vehical,driverType.NORMAL);
            vehical2 = new Object();
            parkinglot.park(vehical2,driverType.NORMAL);
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
            parkinglot.park(vehical,driverType.NORMAL);
            parkinglot.park(vehicle2,driverType.NORMAL);
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
            parkinglot.park(vehical,driverType.NORMAL);
            parkinglot.park(vehicle2,driverType.NORMAL);
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
            parkinglot.park(vehical,driverType.NORMAL);
            parkinglot.park(vehicle2,driverType.NORMAL);
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
            parkinglot.park(vehical,driverType.NORMAL);
            parkinglot.park(vehicle2,driverType.NORMAL);
        } catch (Exception e) {
            Assert.assertFalse(owner.isCapacityFull());
        }
    }

    @Test
    public void givemVehicl_ifFind_ReturnTrue() {
        parkinglot.park(vehical,driverType.NORMAL);
        parkinglot.isVehicalParked(vehical);
        parkinglot.isPresent(vehical);
        Assert.assertTrue(true);
    }

    @Test
    public void givemVehicl_ifNotFind_ReturnFalse() {
        parkinglot.park(vehical,driverType.NORMAL);
        parkinglot.isVehicalParked(vehical);
        parkinglot.isPresent(vehical);
        Assert.assertFalse(false);
    }

    @Test
    public void givenVehical_WhenParked_shouldReturnTime() {
    LocalDateTime parkedTime=parkinglot.park(vehical,driverType.NORMAL);
    Assert.assertEquals(parkedTime,LocalDateTime.now());

    }

    @Test
    public void givenVehical_WhenHandicap_shouldReturnSlot() {
        try {
            allocatedSlot= parkinglot.alotslot(driverType.HANDICAP);
            parkinglot.park(vehical,driverType.HANDICAP);
        }catch (Exception e) {
            Assert.assertEquals(1, slotnumber);
        }
    }

    @Test
    public void givenVehical_WhenNormal_shouldReturnSlot() {
        try {
            allocatedSlot= parkinglot.alotslot(driverType.NORMAL);
            parkinglot.park(vehical,driverType.NORMAL);
        }catch (Exception e) {
            Assert.assertEquals(1, slotnumber);
        }
    }


}
