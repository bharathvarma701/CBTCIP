import java.util.*;
import java.io.*;

class NumberGuessingGame{
    public static void main(String[] args){
        
        Scanner sc=new Scanner(System.in);
        
        int randomNumber=(int)(Math.random()*100)+1;
       
        int count=10;
        System.out.println("Enter a number between 1 to 100 in "+count+" attempts: ");
        int Score;
        
        while(true){
           
            int n=sc.nextInt();
            count--;
            Score=count+1;
            if(count==0){
                System.out.println("Maximum attempts reached.");
                System.out.println("Score: 0");
                break;
            }
            else if(count>0 && randomNumber==n){
                System.out.println("You win!!!");
                System.out.println("Score: "+Score);
                break;
            }
            else if(count>0 && randomNumber>n){
                System.out.println("You have "+count+" attempts left!!");
                System.out.println(" ");
                System.out.println("Enter Higher number:");
            }
            else if(count>0 && randomNumber<n){
                System.out.println("You have "+count+" attempts left!!");
                System.out.println(" ");
                System.out.println("Enter Lower number:");
            }
        }
    }
}
