package ddos;

import java.util.Scanner;

public class MainDOS {
    static DDOS now;
    static Scanner cin = new Scanner(System.in);
    public static void main(String[] args){
        int mode = 1;
        if(mode == 1){
            DDOS.work();
        }
    }
}
