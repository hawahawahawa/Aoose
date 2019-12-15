/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 *
 * @author bibo_121
 */
public class Sha2etyClient {

    private static Home Home;
    private static Register Register;
    private static Login Login;
    private static OwnerRegister OwnerRegister;
    private static ClientFeatures ClientFeatures;
    private static OwnerFeatures OwnerFeatures;
    private static AdminFeatures AdminFeatures;

    private static AuthenticationInterface auth;
    public static int clientCount = 1;
    public static int OwnerCount = 1;
    public static int userCount = 1;

    public static void main(String[] args) {

        initHome();
        initRegister();
        initLogin();

        Home.setVisible(true);

        try {
            Registry r = LocateRegistry.getRegistry(1099);
            auth = (AuthenticationInterface) r.lookup("auth");
        } catch (Exception e) {
            System.out.println("Exception " + e.toString());
        }
    }

    public static void initHome() {
        Home = new Home();
        Home.setLocationRelativeTo(null);
        Home.getRegisterNavButton().addActionListener(new RegisterNavButtonListener());
        Home.getLoginNavButton().addActionListener(new LoginNavButtonListener());
        Home.getOwnerRegisterButton().addActionListener(new OwnerRegisterNavButton());
    }

    public static void initRegister() {
        Home.dispose();
        Register = new Register();
        Register.setLocationRelativeTo(null);
        Register.getRegisterButton().addActionListener(new RegisterButtonListener());
        Register.getLoginNavButton().addActionListener(new LoginNavButtonListener());
    }

    public static void initLogin() {
        Home.dispose();
        Login = new Login();
        Login.setLocationRelativeTo(null);
        Login.getRegisterNavButton().addActionListener(new RegisterNavButtonListener());
        Login.getLoginButton().addActionListener(new LoginButtonListener());
    }

    public static void initOwnerRegister() {
        Home.dispose();
        OwnerRegister = new OwnerRegister();
        OwnerRegister.setLocationRelativeTo(null);
        OwnerRegister.getRegisterButton().addActionListener(new OwnerRegisterButtonListener());
        OwnerRegister.getLoginNavButton().addActionListener(new LoginNavButtonListener());
    }

    public static void initClientFeatures() {
        ClientFeatures = new ClientFeatures();
        ClientFeatures.setLocationRelativeTo(null);
    }

    public static void initOwnerFeatures() {
        OwnerFeatures = new OwnerFeatures();
        OwnerFeatures.setLocationRelativeTo(null);
    }

    public static void initAdminFeatures() {
        AdminFeatures = new AdminFeatures();
        AdminFeatures.setLocationRelativeTo(null);
    }

    static class OwnerRegisterNavButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            Login.dispose();
            initOwnerRegister();
            OwnerRegister.setVisible(true);
        }
    }

    static class RegisterNavButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Login.dispose();
            initLogin();
            Register.setVisible(true);
        }

    }

    static class LoginNavButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Register.dispose();
            initRegister();
            Login.setVisible(true);
        }

    }

    static class RegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String firstName = Register.getFirstName();
                String lastName = Register.getLastName();
                String Address = Register.getAddress();
                String Country = Register.getCountry();
                String Email = Register.getEmail();
                String PN = Register.getPN();
                String Username = Register.getUsername();
                String Password = Register.getPassword();

                boolean result = auth.registerClient(clientCount, 0, userCount, firstName, lastName, Address, PN, Email, Country, Username, Password);

                if (result = false) {
                    JOptionPane.showMessageDialog(null, "Username already exists, please try another one");
                } else {
                    userCount++;
                    clientCount++;

                    JOptionPane.showMessageDialog(null, "Registered successfully, please login");
                    Register.dispose();
                    initRegister();
                    Login.setVisible(true);
                }

            } catch (Exception ex) {
                System.out.println("Exception " + ex.toString());
            }
        }

    }

    static class OwnerRegisterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
    
                String firstName = OwnerRegister.getFirstName();
                String lastName = OwnerRegister.getLastName();
                String Address = OwnerRegister.getAddress();
                String Country = OwnerRegister.getCountry();
                String Email = OwnerRegister.getEmail();
                String PN = OwnerRegister.getPN();
                String Username = OwnerRegister.getUsername();
                String Password = OwnerRegister.getPassword();

                boolean result = auth.registerOwner(OwnerCount, "male", userCount, firstName, lastName, Address, PN, Email, Country, Username, Password);

                if (result = false) {
                    JOptionPane.showMessageDialog(null, "Username already exists, please try another one");
                } else {
                    userCount++;
                    OwnerCount++;

                    JOptionPane.showMessageDialog(null, "Registered successfully, please login");
                    Register.dispose();
                    initRegister();
                    Login.setVisible(true);
                }

            } catch (Exception ex) {
                System.out.println("Exception " + ex.toString());
            }
        }

    }

    static class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String username = Login.getUsername();
                String password = Login.getPassword();

                Account u = auth.login(username, password);

                if (u == null) {
                    JOptionPane.showMessageDialog(null, "Wrong username/password, please try again");
                } else {
                    JOptionPane.showMessageDialog(null, "Logged in sucessfully");
                    Login.dispose();
                    initClientFeatures();
                    initOwnerFeatures();
                    initAdminFeatures();

                    if (u instanceof Client) {
                        ClientFeatures.setUsernameLabel(u.getFullName());
                        ClientFeatures.setVisible(true);
                    } else if (u instanceof Owner) {
                        OwnerFeatures.setUsernameLabel(u.getFullName());
                        OwnerFeatures.setVisible(true);
                    } else if (u instanceof Admin) {
                        AdminFeatures.setUsernameLabel(u.getFullName());
                        AdminFeatures.setVisible(true);
                    }
                }

            } catch (Exception ex) {
                System.out.println("Exception " + ex.toString());
            }
        }

    }

}
