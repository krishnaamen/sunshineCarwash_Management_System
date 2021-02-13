public class WashingCard{
   private int cardId;
   private double balance;
   
   
   public WashingCard(int cardId, double balance){
      this.cardId = cardId;
      this.balance = balance;
   
   }
   
   
   public void setBalance( double balance){
      this.balance = balance;
   }
   public int getCardId(){
      return cardId;
    
   }
   public double getBalance(){
   
      return balance;
   }
   public void washingCardInfo(){
      System.out.println("Card id: " + getCardId()+" Current balance is : "+ getBalance()+".");
   }

}