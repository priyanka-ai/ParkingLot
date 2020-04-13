import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

public class ParkingLotSystem {


 private List parkiingLots= new ArrayList<ParkingLot>();
 private int capacity;
 
    private ArrayList <ParkingLot> parkingLots=new ArrayList<>();
    private ArrayList<Object> vehicalList;
    private ArrayList<Integer> vehicallist;
    private Object vehical;
    private int currentCapacity=0;

    public ParkingLotSystem() {
        this.parkiingLots = parkiingLots;
    }



    public void addNewParkingLot(ParkingLot parkingLot, int capacity){
        parkiingLots.add(parkingLot);
    }
    public void park(Object vehical,driverType type)throws RuntimeException {
        this.vehicalList.add(vehical);
        currentCapacity++;

    }

    boolean isVehicalParked(Object vehical) {
        if(vehicallist.contains(vehical))
            return true;
        return false;
    }
}



