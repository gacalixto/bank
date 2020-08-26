package br.unesp.banco.screens;

import br.unesp.banco.core.ui.JFrameLoader;
import br.unesp.banco.core.ui.JFrameManager;
import br.unesp.banco.screens.login.LoginScreen;

import javax.swing.*;
import java.util.Map;

public class BankApplication {

    private JFrame frame;
    private final JFrameManager frameManager;

    public BankApplication(Map<String, Object> facades) {
        frame = new JFrame("Bank");
        frameManager = new JFrameManager(frame, facades, null);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void run() {
        JFrameLoader.load(frameManager, LoginScreen.class, "Acessar conta");
    }

}
