import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] data = input.split(",");
        System.out.println("Enter Details : ");
        CurrentAccount ac = new CurrentAccount(data[0], data[1], data[2], data[3]);
        ac.display();
        sc.close();
    }
    
}
