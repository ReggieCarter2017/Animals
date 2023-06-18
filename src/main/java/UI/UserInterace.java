package UI;

import java.util.Map;
import java.util.Scanner;

public class UserInterace {

    public int getInt(String msg){
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public String getStr(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.println(msg);
        return scanner.next();
    }

    public String menuContext(Map<String, String> menu) {
        Scanner scanner = new Scanner(System.in);
        String answer;

        for (String n : menu.keySet()) {
            System.out.println(n + ". " + menu.get(n));
        }
        System.out.print(">>> ");

        answer = scanner.nextLine();

        if(!menu.containsKey(answer)){
            answer = "0";
        }

        return answer;
    }

}