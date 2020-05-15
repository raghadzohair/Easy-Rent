/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;

import java.util.*;
import java.io.*;
public class DBR1705628P4_EasyRent {

    
    public static void main(String[] args) throws Exception {
        
        // create Input files samples
        File inputVehicle = new File("inputVehicle.txt");
        File Reservationinput = new File("Reservationinput.txt");
        
        // check if inputVehicle and Reservationinput are exists
        if(!inputVehicle.exists()){
            System.out.println("The File Vehicle is not exist!");
            System.exit(0);
        }
        if(!Reservationinput.exists()){
            System.out.println("The File Reservation is not exist!");
            System.exit(0);
        }
        
        // creeat objects Scanner for read from files
        Scanner input1 = new Scanner(inputVehicle);
        Scanner input2 = new Scanner(Reservationinput);
        
        // create ArrayList to stor data
        ArrayList <Vehicle> vehicle = new ArrayList<>();
        ArrayList <Services> services = new ArrayList<>();
        ArrayList <Reservation> reservation = new ArrayList<>();
        
        //method read from file InputVehicle and close it
        readInputVehicle(input1, vehicle,services);
        input1.close();
        
        //create File output and writer object
        File dataBase = new File("DataBase.txt");
        PrintWriter output1 = new PrintWriter(dataBase);
        // method to prin in file and close this file
        printDataBase(vehicle,output1);
        output1.close();
        
        File ReservationStatus =new File("ReservationStatus.txt");
        PrintWriter output2 = new PrintWriter(ReservationStatus);
        readReservationInput(input2,output2,reservation,vehicle,services);
        input2.close();
        output2.close();
    }
    //// read
    public static void readInputVehicle(Scanner input1, ArrayList <Vehicle> vehicle,ArrayList <Services> services){
        
        while(input1.hasNext()){
            String command = input1.next();                 
            if(command.equalsIgnoreCase("AddTruck")){
                vehicle.add(new Truck(input1.next(),input1.nextInt(),input1.nextDouble(),input1.nextBoolean(),input1.next()));
            }
            else if(command.equalsIgnoreCase("AddBus")){
                vehicle.add(new Bus(input1.next(),input1.nextInt(),input1.nextDouble(),input1.nextBoolean(),input1.nextInt()));
            }
            else if(command.equalsIgnoreCase("AddCar")){
                vehicle.add(new Car(input1.next(),input1.nextInt(),input1.nextDouble(),input1.nextBoolean(),input1.next(),input1.nextBoolean()));
            }
            else if(command.equalsIgnoreCase("AddService")){
                services.add(new Services(input1.next(),input1.nextDouble()));
            }
             
        }    
    }
    /// print
    public static void printDataBase(ArrayList <Vehicle> vehicle,PrintWriter output1){
        output1.println("--------------- Welcome to Car Renting  Data Base ---------------");
        Collections.sort(vehicle);
        for(int i =0; i<vehicle.size();i++){
            output1.println();            
            output1.println(vehicle.get(i));
        }
    }
    /// read
    public static void readReservationInput(Scanner input2,PrintWriter output2,ArrayList <Reservation> reservation,ArrayList <Vehicle> vehicle,ArrayList <Services> services){
        output2.println("--------------- Welcome to Car Renting  Management System ---------------\r\n"
                + "\n--------------- Display All System Procedures ---------------");
        while(input2.hasNext()){
            String command = input2.next();
            if(command.equalsIgnoreCase("Reserve")){
                typeOfTransportation(input2,output2,reservation, services,vehicle);
            }
            else if(command.equalsIgnoreCase("Print_The_Soreted_Reservations'_File_By_PickUp")){
                print();
            }
            else if(command.equalsIgnoreCase("Quit")){
                break;
            }
        }
    }
    /// four method for search
    public static void typeOfTransportation(Scanner input2,PrintWriter output2,ArrayList <Reservation> reservation,ArrayList <Services> services,ArrayList <Vehicle> vehicle){

        while (input2.hasNext()) {
            String types = input2.next();
            String trukType = null;
            boolean Transmission = false;
            boolean convertible = false;
            int seats = 0;
            if (types.equalsIgnoreCase("Truck")) {
                trukType = input2.next();
                Transmission = input2.nextBoolean();
            } 
            else if (types.equalsIgnoreCase("Car")) {
                trukType = input2.next();
                Transmission = input2.nextBoolean();
                convertible = input2.nextBoolean();
            }
            else {
                seats = input2.nextInt();
            }
            String pickupLocation = input2.next();
            String drobupLocation = input2.next();
            Date pickUpDate = new Date(input2.nextInt(), input2.nextInt(), input2.nextInt());
            Date dropOffDate = new Date(input2.nextInt(), input2.nextInt(), input2.nextInt());
            String fristName = input2.next();
            String lastName = input2.next();
            String email = input2.next();
            Long card = input2.nextLong();
            int code = input2.nextInt();
            Customer c = new Customer(fristName, lastName, email, card, code);
            ArrayList<Services> newService = new ArrayList<Services>();
            while (input2.hasNext()) {
                String serviceName = input2.next();
                if (serviceName.equalsIgnoreCase("submit")) {
                    break;
                }
                else if (serviceName.equalsIgnoreCase("Car_Seat") && types.equalsIgnoreCase("Car") == false) {
                    continue;
                }
                newService.add(searchAboutService(services, serviceName));
            }
            Vehicle vehicleObj = null;
            if (types.equalsIgnoreCase("Truck")) {
                vehicleObj = searchAboutTruck(vehicle, Transmission);
            } 
            else if (types.equalsIgnoreCase("Car")) {
                searchAboutCar(vehicle, Transmission, convertible);

            } 
            else {
                searchAboutBus(vehicle, Transmission, seats);

            }
            if (vehicleObj != null) {
                output2.print("Command Reservation: Reserve a " + types + "\r\n");
                Reservation r = new Reservation(pickupLocation, drobupLocation, pickUpDate, pickUpDate, c, vehicleObj);
                // create object to generate random intger number
                Random random1 = new Random();
                r.setReservationCode(fristName.substring(0, 1) + lastName.substring(0, 1) + "_" + random1.nextInt(999) + "_" + vehicleObj.Year_of_construction);
                r.addServices(newService);
                reservation.add(r);

            } 
            else {
                output2.println("\nCommand : " + types + " Reservation: CONFLICT\r\n Sorry ! There is no available " + types + "\n");
            }
        }
    }
    
    public static Services searchAboutService(ArrayList <Services> services, String serviceName){
        // initilis var 
        Services s = null;
        for (int i = 0; i < services.size(); i++) {
            // search sevice
            if(services.get(i).getServicetype().equalsIgnoreCase(serviceName)){
                s = services.get(i);
                break;
            }
        }
        return s;   
    }
    
    public static Truck searchAboutTruck(ArrayList<Vehicle> vehicle,boolean Transmission){
        Truck truck = null;
        for (int i = 0; i < vehicle.size(); i++) {
            if(vehicle.get(i) instanceof Truck){
                truck = (Truck) vehicle.get(i);
                
                if(truck.getTransmissionManual() == Transmission && truck.getReserved().isEmpty()){
                    return truck;
                }
                else{  //////////// check conflict
                    
                }
            }
            else 
                return truck;
        }
        return truck;
    }
    
    public static Car searchAboutCar(ArrayList<Vehicle> vehicle,boolean Transmission,boolean covertible){
        Car car = null;
        for (int i = 0; i < vehicle.size(); i++) {
            if(vehicle.get(i) instanceof Truck){
                car = (Car) vehicle.get(i);
                if(car.getTransmissionManual() == Transmission &&car.isConvetible()== covertible && car.getReserved().isEmpty()){
                    return car;
                }
                else{  //////////// check conflict
                    
                }
            }
            else 
                return car;
        }
        return car;
    }
    
    public static Bus searchAboutBus(ArrayList<Vehicle> vehicle,boolean Transmission,int seats){
        Bus bus = null;
        for (int i = 0; i < vehicle.size(); i++) {
            if(vehicle.get(i) instanceof Truck){
                bus = (Bus) vehicle.get(i);
                if(bus.getTransmissionManual() == Transmission &&bus.getNumbreOfSeat()>=seats && bus.getReserved().isEmpty()){
                    return bus;
                }
                else{  //////////// check conflict
                    
                }
            }
            else 
                return bus;
        }
        return bus;
    }
    
    public static void print(){
        
    }
    
       
       
    
    
}
