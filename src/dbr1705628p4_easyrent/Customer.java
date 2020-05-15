/*
 * Raghad Zohair ID: 1705628 DBR.
 * Program 4 : Easy Rent
 * Email: ryahya0010@stu.kau.edu.sa.
 */
package dbr1705628p4_easyrent;
public class Customer {
    
    private String First_name;
    private String Last_name;   
    private String Email;   
    private long Cridit_Card;   
    private double Discount_code;

    public Customer(String First_name, String Last_name, String Email, long Cridit_Card, double Discount_code) {
        this.First_name = First_name;
        this.Last_name = Last_name;
        this.Email = Email;
        this.Cridit_Card = Cridit_Card;
        this.Discount_code = Discount_code;
    }
    

    public double getDiscountCode() {
        if(this.Discount_code/100>=7 || this.Discount_code<=9){
            return 0.2;
        }
        else if(this.Discount_code/100>=4 || this.Discount_code<=6){
            return 0.15;
        }
        else
           return 0.1; 
        
    }


    public long getCriditCard() {
        return Cridit_Card;
    }

    public void setCriditCard(long Cridit_Card) {
        this.Cridit_Card = Cridit_Card;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public String getLastName() {
        return Last_name;
    }

    public void setLastName(String Last_name) {
        this.Last_name = Last_name;
    }


    public String getFirstName() {
        return First_name;
    }

    public void setFirstName(String First_name) {
        this.First_name = First_name;
    }

    @Override
    public String toString() {
        return "Customer{" + "First_name=" + First_name + ", Last_name=" + Last_name + ", Email=" + Email + ", Cridit_Card=" + Cridit_Card + ", Discount_code=" + Discount_code + '}';
    }

    
}
