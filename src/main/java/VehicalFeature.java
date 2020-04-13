public class VehicalFeature {
    private  String vehicalModelName;
    private  String numberPlate;
    public String size;
    public String colour;


    public VehicalFeature(String size,String vehicalModelName, String numberPlate, String colour) {
        this.size=size;
        this.vehicalModelName = vehicalModelName;
        this.numberPlate = numberPlate;
        this.colour = colour;
    }

    public String getSize(){return size; }

    public String getColour() {
        return colour;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getVehicalModelName() {
        return vehicalModelName;
    }

    @Override
    public String toString() {
        return "VehicalFeature{" +
                "vehicalModelName='" + vehicalModelName + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", size='" + size + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
