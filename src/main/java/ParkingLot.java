import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

public class ParkingLot {

    private int numberOfParkedVehical;
    private int actualCapacityOfLot;
    private List vehicallist;
    private int totalCapacity;
    private List parkingLots;
    private List observers;
    private ParkingLotOwner parkingLotOwner;
    private AirportSecurity airportSecurity;
    private List slotList=null;
    private String parkingType;
    private driverType type;
    private Object vehicle;
    private int avialableSlot;
    private List reverserList;
    private LocalDateTime parkedTime;

    /* public ParkingLot( int totalCapacity, ParkingLot parkingLots) {
         this.numberOfParkedVehical = numberOfParkedVehical;
         this.totalCapacity = totalCapacity;
         this.parkingLots = parkingLots;
     }
 */
    public ParkingLot(int totalCapacity) {
        this.totalCapacity =totalCapacity;
        this.vehicallist=new ArrayList();
        this.slotList=new ArrayList(null);
        this.observers=new ArrayList();
        this.reverserList=new ArrayList();
        this.parkingLotOwner=parkingLotOwner;


    }


    public void registerObserver(ParkingLotObserver observer) {

        observers.add(observer);

    }

    public LocalDateTime park(Object vehical)throws RuntimeException {
        if(isVehicalParked(vehical))
            throw new ParkingLotException("vehical is already parked");
        this.vehicallist.add(vehical);
        parkedTime=LocalDateTime.now();
        numberOfParkedVehical++;
        return parkedTime;
    }

    public boolean isParkingLotFull(){
        if(numberOfParkedVehical == totalCapacity){
            parkingLotOwner.capacityIsFull();
            airportSecurity.capacityIsFull();
            notifyObserver();
            throw new ParkingLotException("parkinglot is full");

        }
        else
        return false;
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


   /* public List addParkingLot(ParkingLot parkingLot){
        parkingLots.add(parkingLot);
    }
*/

   public LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    private void notifyObserver() {
        if (isParkingLotFull()) {
            observers.stream().forEach(e -> System.out.println("Parking lot is full"));
        }
        if (!isParkingLotFull()) {
            observers.stream().forEach(e -> System.out.println("parking lot has a space to park vehical"));
        }
    }


/*public Integer alotslot(driverType type){
        if(numberOfParkedVehical< totalCapacity){
            reverserList=Collections.reverse(slotList);
            if(type==driverType.NORMAL){
                for (int i=totalCapacity; i>0; i--) {
                   if(!isPresent(vehicle))
                      slotList.get(i);
                   return i;
                }
            }
            if(type==driverType.HANDICAP){
                for(int i=0; i<totalCapacity; i++){
                   if(!isPresent(vehicle))
                   slotList.get(i);
                    return i;
                }
            }
        }
    return 0;
}*/


}
