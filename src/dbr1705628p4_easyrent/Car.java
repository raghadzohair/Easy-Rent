/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
public class Car extends Vehicle{
    
    private String CarType;
    private boolean convetible;

    public Car(String Brand,int Year_of_construction,double Vehicle_rate,boolean Transmission_Manual,String CarType, boolean convetible) {
        super(Brand, Year_of_construction, Vehicle_rate, Transmission_Manual);
        this.CarType = CarType;
        this.convetible = convetible;
    }

    

    public boolean isConvetible() {
        return convetible;
    }

    public void setConvetible(boolean convetible) {
        this.convetible = convetible;
    }


    public String getCarType() {
        return CarType;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    @Override
    public double CalculateFinalPrice() {
        if(this.CarType.equalsIgnoreCase("luxury")){
            return super.Vehicle_rate+super.Vehicle_rate*0.1;
        }
        return super.Vehicle_rate;
    }
    
    
    @Override
    public String toString() {
        String convert1=null;
        if(super.Transmission_Manual){
            convert1 = "Manual";
        }
        if(!super.Transmission_Manual){
            convert1 = "Automatic";
        }
        if(this.convetible){
            return " The Truck has a  Type: "+Brand+", Year: "+Year_of_construction+", Transmission: "+convert1+"\r\n"
                + "The truck Type is: "+this.CarType+" and convetible\r\n------------------------------------------------------";
        }
        else {
            return " The Truck has a  Type: "+Brand+", Year: "+Year_of_construction+", Transmission: "+convert1+"\r\n"
                + "The truck Type is: "+this.CarType+"\r\n------------------------------------------------------";
        }
    }
    
    

}
