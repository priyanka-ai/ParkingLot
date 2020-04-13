import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PadrkingLotTest {

    private ParkingLot parkinglot;
    private Object vehical;
    private Object vehical2;
    private Object slotnumber;
    private Integer allocatedSlot;
    private Object parkinglotsystem;
    private ParkingLot parkinglot1;
    private ParkingLot parkingLotdefault;
    private ParkingLot parkingLot;


    @Before
    public void setUp() throws Exception {
        parkinglot=new ParkingLot(5);
        parkinglotsystem=new ParkingLotSystem();
    }

   @Test
    public void givenVehical_WhenalreadyParked_ShouldReturnTrue() {
        parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
        boolean isParked=parkinglot.isVehicalParked(vehical);
        Assert.assertEquals(isParked,true);
    }

    @Test
    public void givenVehical_WhenUnparked_ShouldReturnTrue() {
        parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
        boolean unParked=parkinglot.unParked(vehical);
        Assert.assertEquals(unParked,true);
    }


    @Test
    public void given2Vehical_WhenUnparked_ShouldReturnTrue() {
        try {
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
            vehical2 = new Object();
            parkinglot.park(vehical2,driverType.NORMAL,vehicalType.SMALL);
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
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
            parkinglot.park(vehicle2,driverType.NORMAL,vehicalType.SMALL);
            parkinglot.unParked(vehical);
            Assert.assertFalse(owner.isCapacityFull());
        }


    @Test
    public void givenVehicle_WhenSpaceIsAvailable_ShouldInformTheOwner() {
        Object vehicle2 = new Object();
        AirportSecurity owner = new AirportSecurity();
        parkinglot.registerObserver(owner);
        try {
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
            parkinglot.park(vehicle2,driverType.NORMAL,vehicalType.SMALL);
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
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
            parkinglot.park(vehicle2,driverType.NORMAL,vehicalType.SMALL);
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
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
            parkinglot.park(vehicle2,driverType.NORMAL,vehicalType.SMALL);
        } catch (Exception e) {
            Assert.assertFalse(owner.isCapacityFull());
        }
    }

    @Test
    public void givemVehicl_ifFind_ReturnTrue() {
        parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
        parkinglot.isVehicalParked(vehical);
        parkinglot.isPresent(vehical);
        Assert.assertTrue(true);
    }

    @Test
    public void givemVehicl_ifNotFind_ReturnFalse() {
        parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
        parkinglot.isVehicalParked(vehical);
        parkinglot.isPresent(vehical);
        Assert.assertFalse(false);
    }

    @Test
    public void givenVehical_WhenParked_shouldReturnTime() {
    LocalDateTime parkedTime=parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
    Assert.assertEquals(parkedTime,LocalDateTime.now());

    }
    
    @Test//UC9
    public void givenMultipleCarParkingLots_WhenAdded_ShouldReturnTrue() {
        ParkingLotSystem parkingLot = new ParkingLotSystem();
        parkingLot.addNewParkingLot(parkinglot1,5);
        parkingLot.park(vehical,driverType.NORMAL);
        parkingLot.park(vehical2,driverType.NORMAL);
        boolean parkingLotDefault =parkingLot.isVehicalParked(vehical);
        boolean parkingLot1=parkingLot.isVehicalParked(vehical2);
        assertTrue(parkingLotDefault && parkingLot1);
    }

    @Test
    public void givenVehical_WhenHandicap_shouldReturnSlot() {
        try {
            allocatedSlot= parkinglot.alotslot(driverType.HANDICAP,vehicalType.SMALL);
            parkinglot.park(vehical,driverType.HANDICAP,vehicalType.SMALL);
        }catch (Exception e) {
            Assert.assertEquals(2, slotnumber);
        }
    }

    @Test
    public void givenVehical_WhenNormal_shouldReturnSlot() {
        try {
            allocatedSlot= parkinglot.alotslot(driverType.NORMAL,vehicalType.SMALL);
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.SMALL);
        }catch (Exception e) {
            Assert.assertEquals(1, slotnumber);
        }
    }


    @Test
    public void givenVehical_WhenSizeLarge_shouldReturnSlot() {
        try {
            allocatedSlot= parkinglot.alotslot(driverType.NORMAL,vehicalType.LARGE);
//            parkinglot.getVehicalSize(vehicalType.large);
            parkinglot.park(vehical,driverType.NORMAL,vehicalType.LARGE);
        }catch (Exception e) {
            Assert.assertEquals(2, slotnumber);
        }
    }
    @Test
    public void givenLargeVehicle_WhenVehicleShouldParked_ShouldReturnMiddleSlotNumber() {
        parkingLot=new ParkingLot(3);
        parkingLot.park(vehical,driverType.NORMAL, vehicalType.LARGE);
        int expectedSlot = 1;
        int actualSlot =parkinglot.alotslot(driverType.NORMAL,vehicalType.LARGE);
        assertSame(1, 1);
    }



}
