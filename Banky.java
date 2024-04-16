import java.util.Scanner;

class BankInfo{
    private String name;
    private String acc_no;
    private String acc_type;
    private long balance;
    
    Scanner sc=new Scanner(System.in);
    
    public void createAccount(){
        System.out.println("Enter your Name: ");
        name=sc.nextLine();
        System.out.println("Enter your Account number: ");
        acc_no=sc.nextLine();
        System.out.println("Enter your Account Type: ");
        acc_type=sc.nextLine();
        System.out.println("Enter your Account Ballance: ");
        balance=sc.nextLong();
    }
    
    public void displayAccount(){
        System.out.println("Account Holder: "+name);
        System.out.println("Account Number: "+acc_no);
        System.out.println("Account Type: "+acc_type);
        System.out.println("Balance: "+balance);
    }
    
    public void deposit(){
        long rupee;
        System.out.println("Enter the amount to deposit: ");
        rupee=sc.nextLong();
        balance+=rupee;
    }
    
    public void withdraw(){
        long cash;
        System.out.println("Enter the amount to withdraw");
        cash=sc.nextLong();
        if(balance>=cash){
            balance-=cash;
            System.out.println("Account Balance: "+balance);
        }else{
            System.out.println("Insufficient Funds!!!");
        }
    }
    
    public boolean search(String accNo){
        if(acc_no.equals(accNo)){
            displayAccount();
            return true;
        }
        return false;
    }
}
public class Banky{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of customers:");
        int n=sc.nextInt();
        BankInfo b[]=new BankInfo[n];
        for(int i=0;i<b.length;i++){
            b[i]=new BankInfo();
            b[i].createAccount();
        }
        int choice;
        do{
            System.out.println("***BANKY***");
            System.out.println("1.Display Account Details\n 2.Deposit Amount\n 3.Withdraw Amount\n 4.Search Account\n 5.Close");
            System.out.println("Enter an option: ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    for(int i=0;i<b.length;i++){
                        b[i].displayAccount();
                    }
                    break;
                case 2:
                    System.out.println("Enter Account number: ");
                    String accNo=sc.nextLine();
                    accNo=sc.nextLine();
                    boolean found=false;
                    for(int i=0;i<b.length;i++){
                        found=b[i].search(accNo);
                        if(found){
                            b[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("No Matches Found");
                    }
                    break;
                case 3:
                     System.out.println("Enter Account number: ");
                     accNo=sc.nextLine();
                     accNo=sc.nextLine();
                     found=false;
                    for(int i=0;i<b.length;i++){
                        found=b[i].search(accNo);
                        if(found){
                            b[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("No Matches Found");
                    }
                    break;
                case 4:
                     System.out.println("Enter Account number: ");
                     accNo=sc.nextLine();
                     accNo=sc.nextLine();
                     found=false;
                    for(int i=0;i<b.length;i++){
                        found=b[i].search(accNo);
                        if(found){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("No Matches Found");
                    }
                    break;
                case 5:    
                    System.out.println("Thank you for Banking with us");
                    break;
            }
        }while(choice!=5);
    }
}
