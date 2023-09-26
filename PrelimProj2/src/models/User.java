package models;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private String username;
    private String password;

    public User() {
        // Default constructor
    }

    public User(String username, String password) {
        this.username = username;
        this.password = hashString(password);
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
}
