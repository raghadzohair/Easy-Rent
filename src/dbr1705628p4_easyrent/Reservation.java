/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;


public class Reservation implements IsConflict,Comparable<Reservation>{
    private String Reservation_code;   
    private String pick_up_location; 
    private String drop_of_location;
    private Date Pick_up;
    private Date Drop_of;
    private Date Date_of_reservation;
    private Customer customer;
    private Vehicle vehicle;
    private File invoice;
    private ArrayList<Services> additional_services= new ArrayList<>();

    public Reservation(String pick_up_location, String drop_of_location, Date Pick_up, Date Drop_of, Customer customer, Vehicle vehicle) {
        this.pick_up_location = pick_up_location;
        this.drop_of_location = drop_of_location;
        this.Pick_up = Pick_up;
        this.Drop_of = Drop_of;
        this.customer = customer;
        this.vehicle = vehicle;
        this.Date_of_reservation = new Date();
        
    }
    

    public void addServices(ArrayList<Services> additional_services) {
        this.additional_services = additional_services;
    }
    
    public ArrayList<Services> getListOfServices() {
        return additional_services;
    }

    
    public File getInvoice() {
        return invoice;
    }

    public void setInvoice(File invoice) {
        this.invoice = invoice;
    }

    
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    
    public Customer getCustomer() {
        return customer;
    }

    
    public Date getDateOfReservation() {
        return Date_of_reservation;
    }

    
    public Date getDropOf() {
        return Drop_of;
    }

    public void setDropOf(Date Drop_of) {
        this.Drop_of = Drop_of;
    }

    
    public Date getPickUp() {
        return Pick_up;
    }

    public void setPickUp(Date Pick_up) {
        this.Pick_up = Pick_up;
    }

    
    public String getDropOfLocation() {
        return drop_of_location;
    }

    public void setDropOfLocation(String drop_of_location) {
        this.drop_of_location = drop_of_location;
    }

    
    public String getPickUpLocation() {
        return pick_up_location;
    }

    public void setPickUpLocation(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }


    public String getReservationCode() {
        return Reservation_code;
    }

    public void setReservationCode(String Reservation_code) {
        this.Reservation_code = Reservation_code;
    }
    
    
    @Override
    public String toString() {
        return "Reservation{" + "Reservation_code=" + Reservation_code + ", pick_up_location=" + pick_up_location + ", drop_of_location=" + drop_of_location + ", Pick_up=" + Pick_up + ", Drop_of=" + Drop_of + ", Date_of_reservation=" + Date_of_reservation + ", customer=" + customer + ", vehicle=" + vehicle + ", invoice=" + invoice + ", additional_services=" + additional_services + '}';
    }

    @Override
    public int compareTo(Reservation t) {
        if(this.Pick_up.compareTo(t.Pick_up)>0){
            return 1;
        }
        else if(this.Pick_up.compareTo(t.Pick_up)<0){
            return -1;
        }
        else
            return 0;
    }


    @Override
    public boolean Conlict(Object o) {
        Date date = (Date) o; // for casting
        if(this.Drop_of.compareTo(date)>0) { // = 1
            return true;
        }
        else
            return false;
    }

    
}
