public class ParkingLotOwner implements ParkingLotObserver {
    private boolean isFullCapacity=true;

    public void capacityIsFull() {
        isFullCapacity = true;
    }
    public boolean isCapacityFull() {
        return isFullCapacity;
    }
}

