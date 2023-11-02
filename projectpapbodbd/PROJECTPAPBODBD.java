/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectpapbodbd;

import projectpapbodbd.view.FormLogin;
import projectpapbodbd.view.Formsplash;

public class PROJECTPAPBODBD { 

    public static void main(String[] args) {
            Formsplash splash = new Formsplash();
            splash.setVisible(true);
            FormLogin login = new FormLogin();

            try{
                for (int i=0; i<=100; i++) {
                    Thread.sleep(50);
                    splash.loadingnum.setText(Integer.toString(i)+ "%");
                    splash.loadingbar.setValue(i);
                    if(i==100){
                        splash.setVisible(false);
                        login.setVisible(true);
                    }
                }
            }
            catch (Exception e) {       
            }
        }
    }
