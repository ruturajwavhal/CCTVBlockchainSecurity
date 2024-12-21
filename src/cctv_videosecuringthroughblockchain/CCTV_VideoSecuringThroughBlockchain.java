/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cctv_videosecuringthroughblockchain;

import GUI.LoginFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class CCTV_VideoSecuringThroughBlockchain {

    public static void main(String[] args) {
        LoginFrame lf = new LoginFrame();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        lf.setSize(d);
        lf.setVisible(true);
    }
    
}
