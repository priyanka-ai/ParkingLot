public class AirportSecurity implements ParkingLotObserver {
    private boolean isFullCapacity;

    public void capacityIsFull() {
        isFullCapacity = true;
    }
    public boolean isCapacityFull() {
        return isFullCapacity;
    }

    @Override
    public void notifyObserver() {

    }

}
