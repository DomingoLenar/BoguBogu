package models;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class User {
    private String username;
    private String password;

    public User() {
        // Default constructor
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    private String hashString(String toHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(toHash.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPassword(String password) {
        this.password = password;
        updatePasswordHash();
    }

    private void updatePasswordHash() {
        this.password = hashString(this.password);
    }

    public boolean isPassValid(String pass) {
        String hashedPass = hashString(pass);
        return hashedPass.equals(this.password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void createUserFile() {
        try {
            File file = new File(this.username + ".txt");
            if (file.createNewFile()) {
                FileWriter writer = new FileWriter(file);
                writer.write(this.username + " , " + this.password);
                writer.close();
                System.out.println("User file created: " + file.getName());
            } else {
                System.out.println("User file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Test Code
    public static void main(String[] args) {
        User user1 = new User("user1", "");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        user1.setPassword(password);

        System.out.println("User 1 Hash: " + user1.password);

        System.out.print("Verify Password: ");
        String inputPassword = scanner.nextLine();

        if (user1.isPassValid(inputPassword)) {
            System.out.println("Password is Valid.");
            user1.createUserFile();
        } else {
            System.out.println("Password is Invalid. User File is not Created.");
        }
    }
}
