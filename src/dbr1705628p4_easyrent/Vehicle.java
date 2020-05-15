/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
import java.util.ArrayList;
public abstract class Vehicle implements Comparable<Vehicle> {
    
    protected String Brand;
    protected int Year_of_construction;
    protected double Vehicle_rate; 
    protected boolean Transmission_Manual; 
    protected ArrayList<Reservation> reserved;

    public Vehicle(String Brand, int Year_of_construction, double Vehicle_rate, boolean Transmission_Manual) {
        this.Brand = Brand;
        this.Year_of_construction = Year_of_construction;
        this.Vehicle_rate = Vehicle_rate;
        this.Transmission_Manual = Transmission_Manual;
    }
    
    

    public ArrayList<Reservation> getReserved() {
        return reserved;
    }

    public void setReserved(ArrayList<Reservation> reserved) {
        this.reserved = new ArrayList<>();
    }

    
    public boolean getTransmissionManual() {
        return Transmission_Manual;
    }

    public void setTransmissionManual(boolean Transmission_Manual) {
        this.Transmission_Manual = Transmission_Manual;
    }


    public double getVehicleRate() {
        return Vehicle_rate;
    }

    public void setVehicleRate(double Vehicle_rate) {
        this.Vehicle_rate = Vehicle_rate;
    }


    public int getYearOfConstruction() {
        return Year_of_construction;
    }

    public void setYearOfConstruction(int Year_of_construction) {
        this.Year_of_construction = Year_of_construction;
    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
    
    public int compareTo(Vehicle v){
        if(this.Year_of_construction > v.Year_of_construction ){
            return -1;
        }
        else if(this.Year_of_construction<v.Year_of_construction){
            return 1;
        }
        else
            return 0;
    }

    public abstract double CalculateFinalPrice();
    
    @Override
    public String toString() {
        return "Type :" + Brand + ", Year :" + Year_of_construction + ", Vehicle rate :" + Vehicle_rate + ", Transmission Manual:" + Transmission_Manual + ", reserved:" + reserved ;
    }
    
    

    
}
