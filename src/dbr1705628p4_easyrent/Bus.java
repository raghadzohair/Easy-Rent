/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
public class Bus extends Vehicle{
    
        private int numbreOfSeat;

    public Bus(String Brand,int Year_of_construction,double Vehicle_rate,boolean Transmission_Manual,int numbreOfSeat) {
        super(Brand, Year_of_construction, Vehicle_rate, Transmission_Manual);
        this.numbreOfSeat = numbreOfSeat;
    }

    

    public int getNumbreOfSeat() {
        return numbreOfSeat;
    }

    public void setNumbreOfSeat(int numbreOfSeat) {
        this.numbreOfSeat = numbreOfSeat;
    }

    @Override
    public double CalculateFinalPrice() {
        return super.Vehicle_rate;
    }

    @Override
    public String toString() {
        String convert = null;
        if(super.Transmission_Manual == true){
            convert = "Manual";
        }
        if(super.Transmission_Manual == false){
            convert = "Automatic";
        }
        return " The Truck has a  Type: "+Brand+", Year: "+Year_of_construction+", Transmission: "+convert+"\r\n"
                + "The truck Type is: "+this.numbreOfSeat+"\r\n------------------------------------------------------";
    }
    

    



   
    
}
