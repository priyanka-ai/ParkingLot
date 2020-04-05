public interface ParkingLotObserver {
    public void capacityIsFull();
    public boolean isCapacityFull();
    public void notifyObserver();
}
