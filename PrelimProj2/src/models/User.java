package models;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import datastruc.SingleLinkedList;
import datastruc.SingleNode;
import tools.FileHandling;

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
        this.password = hashString(password);
    }


    public boolean isPassValid() throws FileNotFoundException {
        FileHandling handler = new FileHandling();
        File creds = new File("PrelimProj2/src/data/" + username + "/credentials.txt");
        Scanner in = new Scanner(creds);
        String[] data = in.nextLine().split(",");
        return (password.equals(data[1]));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void createUserFile() {
        FileHandling fileHandler = new FileHandling();
        String userFolder = "PrelimProj2/src/data/"+username;
        if(!fileHandler.directoryExists(userFolder)){
            try {
                fileHandler.createDirectory(userFolder);
            }catch(Exception directoryCreation){
                directoryCreation.printStackTrace();
            }
        }
            try {
                File file = new File(userFolder+"/credentials.txt");
                if (file.createNewFile()) {
                    FileWriter writer = new FileWriter(file);
                    writer.write(this.username + "," + this.password);
                    writer.close();
                    System.out.println("User file created: " + file.getName());
                } else {
                    System.out.println("User file already exists.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


    public SingleLinkedList<SingleLinkedList<Email>> fetchMails(String type){

        Scanner dataScanner = null;

        SingleLinkedList<Email> thread = new SingleLinkedList<>();
        SingleLinkedList<SingleLinkedList<Email>> listOfThreads = new SingleLinkedList<>();

        File data = new File("PrelimProj2/src/data/"+username+"/"+type+".txt");
        try{
            dataScanner = new Scanner(data);
        }catch(FileNotFoundException fNFE){
            fNFE.printStackTrace();
        }
        String currentS = null;
        while(dataScanner.hasNext()){
            String[] rawData = dataScanner.nextLine().split(",");
            String sender, receiver, subject, body;
            sender = rawData[0];
            receiver = rawData[1];
            subject = rawData[2];
            body = rawData[3];
            Email mail = new Email(sender, receiver,subject, body);
            if(!subject.equals(currentS) || currentS == null){
                thread.add(mail);
                currentS = subject;
            }else{
                listOfThreads.add(thread);
                currentS = subject;
                thread = null;
                thread.add(mail);
            }
        }
        return listOfThreads;
    }

    public void saveRuntimeMails(SingleLinkedList<SingleLinkedList<Email>> listOfThreads, String type){
        FileHandling handler = new FileHandling();
        if(handler.directoryExists("PrelimProj2/src/data/"+username)){
            File inboxFile = new File("PrelimProj2/src/data/"+username+"/"+type+".txt");
            File sentFile = new File("PrelimProj2/src/data/"+username+"/sent.txt");
            try{
                PrintWriter inboxOutput = new PrintWriter(inboxFile);
                PrintWriter sentOutput = new PrintWriter(sentFile);
                if(inboxFile.exists()){
                    SingleNode<SingleLinkedList<Email>> currentThreadNode = listOfThreads.getHead();
                    SingleNode<Email> threadPointer = currentThreadNode.getData().getHead();
                    for(int x = 0; x < listOfThreads.getSize();x++){
                        for(int y = 0; y < currentThreadNode.getData().getSize(); y++){
                            inboxOutput.println(threadPointer.getData().toString());
                            inboxOutput.flush();
                            if(threadPointer.getData().getSender().equals(username)){
                                sentOutput.println(threadPointer.getData().toString());
                                sentOutput.flush();
                            }
                            threadPointer = threadPointer.getLink();
                        }
                        currentThreadNode = currentThreadNode.getLink();
                    }
                    sentOutput.close();
                    inboxOutput.close();
                }
            }catch(FileNotFoundException outputError){
                outputError.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        User testUser = new User("Lestat","Lestat10");
        testUser.createUserFile();
    }
}
