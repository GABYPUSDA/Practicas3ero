/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package DIU;

import DiuVista.Login1;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Main {

    public static ArrayList<Fletes> fletes;
    public static void main(String[] args) {
        fletes = new ArrayList<>();
        Login1 loginFrame = new Login1();
        
        // Hacer visible el frame de Login1
        loginFrame.setVisible(true);
    }
}
