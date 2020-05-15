/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
public class Services {
    private String servicetype; 
    private double serviceprice;

    public Services(String servicetype, double serviceprice) {
        this.servicetype = servicetype;
        this.serviceprice = serviceprice;
    }        

    public double getServiceprice() {
        return serviceprice;
    }

    public void setServiceprice(double serviceprice) {
        this.serviceprice = serviceprice;
    }


    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    @Override
    public String toString() {
        return "servicetype :" + servicetype + ", serviceprice :" + serviceprice ;
    }
    
    

}
