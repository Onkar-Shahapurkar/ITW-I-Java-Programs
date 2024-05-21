import java.util.*;

public class practice {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println(" 1. Try\n 2. Finally\n 3. Throw\n 4. Throws");
        System.out.println("Enter your Choice: ");
        choice = sc.nextInt();
        
        switch(choice){
            case 1:
                try{
                    System.out.println("Number division 10/0: " + 10/0);
                }catch(ArithmeticException e){
                    System.out.println(e);
                }
            break;
                
            case 2:
                int ar[]={1, 2, 3, 4, 5};
                for(int i = 0; i <= ar.length; i++){
                    System.out.println(ar[i] + "\n");
                }
            break;
                
                
            case 3:
                
                
            case 4:
                
        }
        
    }
    
}
