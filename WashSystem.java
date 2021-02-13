import java.util.*;
import java.io.*;
import java.text.*;


public class WashSystem{
   Scanner scanner = new Scanner(System.in);
   static int count =0;   
   public static int[] arr = new int[count];
   
   public static WashingCard[] wCard = new WashingCard[5];
   public static Customer[] customer = new Customer[5];
   public static int[] arrCount = new int[customer.length];
   public static double [] totalAmountSpent = new double[count];
   public static double[] eachTotalSpent = new double[arrCount.length];



   public static void main(String[]args)throws FileNotFoundException{
   Scanner scanner = new Scanner(System.in);
   wCard[0] = new WashingCard(1, 300.0);
   wCard[1] = new WashingCard(2, 400.0);
   wCard[2] = new WashingCard(3, 900.0);
   wCard[3] = new WashingCard(4, 300.0);
   wCard[4] = new WashingCard(5, 700.0);
      
   customer[0] = new Customer("Robert",1, wCard[0]);
   customer[1] = new Customer("Tom",2, wCard[1]);
   customer[2] = new Customer("Søren",3, wCard[2]);
   customer[3] = new Customer("John",4, wCard[3]);
   customer[4] = new Customer("Martin",5, wCard[4]);
   boolean isExit = false;
   while(!isExit){
   System.out.println("Do you want to continue? y/n");
   String ans = scanner.next();
   if(ans.equals("n")){
    isExit=true;
    Arrays.sort(arr);
    Date date = new Date();
    
    updateStatstics("===========Statstics for "+(date.toString())+" ==========================================\n\n");
  
    String result = Arrays.toString(arr);
    String result2 = Arrays.toString(arrCount);
    String result3 = Arrays.toString(totalAmountSpent);
    String result4 = Arrays.toString(eachTotalSpent);
    
    for(int i = 0;i<customer.length;i++){
    if (arrCount[i]>0){
        updateStatstics("      "+customer[i-1].printCustomerInfo()+" Visisted for " +arrCount[i]+" times and spent "+ eachTotalSpent[i]+"DKK.");
    }
    
    }
    
    updateStatstics("\n\n     Total earning  "+String.valueOf(sumAmount(eachTotalSpent))+"   DKK.");
   
updateStatstics("\n\n");
    
    }
   else{
   
   chooseWashType();
   }
   }
         }
  
  public static void chooseWashType(){
 
   Scanner scanner = new Scanner(System.in);
   System.out.println("===========================");
   System.out.println("Choose following options:-");
   System.out.println("1- for check balance\n2- for wash car\n3-for recharge Card ");
   System.out.println("===========================");
   int option = scanner.nextInt();
   
   switch(option){
   case 1:
   checkBalance();
   break;
   case 2:
   washOptions();
   chooseBuy();
   break;
   case 3:
   rechargeCard();
   break;
   default:
   System.out.println("Please enter the valid number between 1-3.");
   break;
   }
   }
  
   public static void checkBalance(){
      System.out.println("Your balance  is " + wCard[0].getBalance()+" DKK");   }
   public static void washOptions(){
      System.out.println("1-economy,2-standard,3-Deluxe");
   }
   public static void chooseBuy(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter the customerID:");
      int i = scanner.nextInt();
      
      
      
      arr = addInt(arr,i);
      
      arrCount[i]= arrCount[i]+1;
 
      Date d = new Date();
      SimpleDateFormat timeFormat = new SimpleDateFormat("hh");
      String myTime=timeFormat.format(d);
      int currentTime = Integer.parseInt(myTime);
      
      System.out.println("Choose the options 1.Economy - 50DKK,\n2-Standard-80Dkk\n,3-De luxe-120 Dkk");
      
      int buyOption = scanner.nextInt();
      switch(buyOption){
         case 1:
               if((wCard[i].getBalance()>=50)&& (currentTime>=06) &&(currentTime<=13)){
                  double firstBalance = wCard[i].getBalance();
                  //double discount = 50*20/100 = 10
                  wCard[i].setBalance(firstBalance-40);
                  double secondBalance = wCard[i].getBalance();
                  double totalSpent = firstBalance - secondBalance;
                  totalAmountSpent = addDouble(totalAmountSpent,totalSpent);
                  eachTotalSpent[i]= eachTotalSpent[i]+totalSpent;
                 
                  
                  System.out.println("Thank you for choosing economy option\n You got 20% discount(From 6am to 14pm)\nYour current balance is"+ wCard[i-1].getBalance());               
                  }
               else if((wCard[i].getBalance()>=50)&& (currentTime<06) ||(currentTime>13)){
                  double firstBalance = wCard[i].getBalance();
                  wCard[i].setBalance(wCard[i].getBalance()-50);
                  double secondBalance = wCard[i].getBalance();
                  double totalSpent = firstBalance - secondBalance;
                  totalAmountSpent = addDouble(totalAmountSpent,totalSpent);
                  eachTotalSpent[i]= eachTotalSpent[i]+totalSpent;
                  System.out.println("Your current balance is"+ wCard[i].getBalance());
                  }
               else {
                  System.out.println("You have insufficient balance please recharge first.");
                  rechargeCard();
                     }
            break;
               
           case 2:
               if((wCard[i].getBalance()>=80)&& (currentTime>=06) &&(currentTime<=13)){
                  //double discount = 80*20/100 = 16
                  double firstBalance = wCard[i].getBalance();
                  wCard[i].setBalance(wCard[i].getBalance()-64);
                  double secondBalance = wCard[i].getBalance();
                  double totalSpent = firstBalance - secondBalance;
                  totalAmountSpent = addDouble(totalAmountSpent,totalSpent);
                  eachTotalSpent[i]= eachTotalSpent[i]+totalSpent;

                  System.out.println("Thank you for choosing standard option\n You have got 20% discount\nYour current balance is"+ wCard[i].getBalance());
                  }              
                  
               else if((wCard[i].getBalance()>=80)&& (currentTime<06) ||(currentTime>13)){
                  double firstBalance = wCard[i].getBalance();
                  wCard[i].setBalance(wCard[i].getBalance()-80);
                  System.out.println("Your current balance is"+ wCard[i].getBalance());
                  double secondBalance = wCard[i].getBalance();
                  double totalSpent = firstBalance - secondBalance;
                  totalAmountSpent = addDouble(totalAmountSpent,totalSpent);
                  eachTotalSpent[i]= eachTotalSpent[i]+totalSpent;
                  }
               else {
                     System.out.println("You have insufficient balance please recharge first.");
                     rechargeCard();
               
               }
               break;
               
               
               case 3:
               if(wCard[i].getBalance()>=120){ 
                  double firstBalance = wCard[i].getBalance();                 
                  wCard[i].setBalance(wCard[i].getBalance()-120);
                  double secondBalance = wCard[i].getBalance();
                  double totalSpent = firstBalance - secondBalance;
                  totalAmountSpent = addDouble(totalAmountSpent,totalSpent);
                  eachTotalSpent[i]= eachTotalSpent[i]+totalSpent;
                  System.out.println("Your current balance is"+ wCard[i].getBalance());               
                  }
               else{
               System.out.println("You have insufficient balance please recharge first.");
               rechargeCard();
               
               }
               break;
 
      }
      
      
      
      
      
   }
   
   public static void rechargeCard(){
      Scanner scanner = new Scanner(System.in);
      System.out.println("How much money would you like to deposit on your wash card?");
      double rechargeAmount = scanner.nextDouble();
      wCard[0].setBalance(wCard[0].getBalance() + rechargeAmount);
      System.out.println("Your new balance is " +wCard[0].getBalance() + "DKK");    
   
   }

  
  public static void updateStatstics(String text){
      
    String s = "statstics.txt";  

      PrintWriter wr = null;      
       try{
       
      FileWriter fw = new FileWriter(s,true);
      wr = new PrintWriter(fw);}
      catch(FileNotFoundException err){
      err.printStackTrace();
  
      }
      catch(IOException e)
      {
      e.printStackTrace();
      }
      wr.println(text);
      
       wr.close();

 }
 
    public static int[] addInt(int [] arr, int newInt){
    
    int[] newArr = new int[arr.length + 1];

        
    for (int i = 0; i < arr.length; i++){
        newArr[i] = arr[i];
    }
     
    newArr[newArr.length - 1] = newInt;

   

    return newArr;

     } 
     
     public static double[] addDouble(double []totalAmountSpent, double amountSpent){
    
    double[] newArr = new double[totalAmountSpent.length + 1];

        
    for (int i = 0; i < totalAmountSpent.length; i++){
        newArr[i] = totalAmountSpent[i];
    }
     
    newArr[newArr.length-1] = amountSpent;

   

    return newArr;

     } 

     
     
     public static double sumAmount(double[]sumArr){
      double sum =0;
      int i;
     for(i=0;i<sumArr.length;i++){
      sum = sum+sumArr[i];
     
     }
     return sum;
     
     }
     
     
     }
     
     
             
     
     
     
     
            

  
  
  
  
   
   

