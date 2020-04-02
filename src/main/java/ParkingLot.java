import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingLot {

    private int numberOfParkedVehical;
    private int actualCapacityOfLot;
    private List vehicallist;
    private int totalCapacity;
    private List parkingLot;
    private List observers;
    private ParkingLotOwner parkingLotOwner;
    private AirportSecurity airportSecurity;
    private List slotList;
    private String parkingType;
    private driverType type;
    private Object vehicle;
    private int avialableSlot;


    public ParkingLot(int totalCapacity) {
        this.totalCapacity =totalCapacity;
        this.vehicallist=new ArrayList();
        this.slotList=new ArrayList();
        this.observers=new ArrayList();
        this.parkingLotOwner=parkingLotOwner;


    }


    public void registerObserver(ParkingLotObserver observer) {
        observers.add(observer);
    }

    public void park(Object vehical)throws RuntimeException {
        if(isVehicalParked(vehical))
            throw new ParkingLotException("vehical is already parked");
        this.vehicallist.add(vehical);
        numberOfParkedVehical++;
        if(numberOfParkedVehical == totalCapacity){
            parkingLotOwner.capacityIsFull();
            airportSecurity.capacityIsFull();
            throw new ParkingLotException("parkinglot is full");

        }
    }

    public int parkedVehicalinLot(){
        return numberOfParkedVehical;
    }

    public int emptySpace(){
        return totalCapacity-numberOfParkedVehical;
    }

    public boolean isVehicalParked(Object vehical) {
        if(vehicallist.contains(vehical))
            return true;
        return false;
    }

    public boolean unParked(Object vehical){
        if(vehicallist.contains(vehical)) {
            vehicallist.remove(vehical);
            numberOfParkedVehical--;
            return true;
        }
        return false;
    }

    public boolean isPresent(Object vehical){
        if(vehicallist.contains(vehical))
        return true;
        return false;
    }


   /* public LocalDateTime getTime(){
        return LocalDateTime.now();
    }

private int alotslot(driverType type){
        if(numberOfParkedVehical< totalCapacity){
            if(type==driverType.NORMAL){
                for (int i=0; i<totalCapacity; i++) {
                    if(vehicallist.indexOf(i) == 0)
                        return i;
                    
                }
                return slotList.indexOf(slotList);
            }
            if(type==driverType.NORMAL){
                return slotList.indexOf(slotList);
            }
        }


    return 0;
}

    public boolean getSlot(Object vehicle, int avialableSlot) {
        if (numberOfParkedVehical <= totalCapacity) {
            this.vehicle = vehicle;
            this.avialableSlot = avialableSlot;
            avialableSlot++;
            park(vehicle);
            return true;
        }
        return false;
    }
*/
}
