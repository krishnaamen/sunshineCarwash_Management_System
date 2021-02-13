import java.util.*;

public class Customer{
   private String name;
   private int Id;
   WashingCard wCard;
   
   public Customer(String name, int Id,WashingCard wCard){
      this.name = name;
      this.Id = Id;
      this.wCard = wCard;
   }
   
   public void setCustomer(String name,int Id,WashingCard wCard){
      this.name = name;
      this.Id = Id;
      this.wCard = wCard;
   
   }
   public String getCustomerName(){
      return name;   
   }
   
   public int getCustomerId(){
      return Id;
  }
   public WashingCard getwCard(){
      return wCard;
   }
   public String printCustomerInfo(){
   
   return ("Name: "+getCustomerName()+ " with id:- "+ getCustomerId());
   
   }

}