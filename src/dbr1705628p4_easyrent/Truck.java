/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
public class Truck extends Vehicle{
    
    private String TruckType;

    public Truck(String Brand,int Year_of_construction,double Vehicle_rate,boolean Transmission_Manual,String TruckType) {
        super(Brand, Year_of_construction, Vehicle_rate, Transmission_Manual);
        this.TruckType = TruckType;
    }
    

    public String getTruckType() {
        return TruckType;
    }

    public void setTruckType(String TruckType) {
        this.TruckType = TruckType;
    }
    
    public double CalculateFinalPrice(){
        if(this.TruckType.equalsIgnoreCase("Concrete_mixer")){
            return super.Vehicle_rate + super.Vehicle_rate*0.05;
        }
        else{
            return super.Vehicle_rate;
        }
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
                + "The truck Type is: "+this.TruckType+"\r\n------------------------------------------------------";
    }

    

  

}
