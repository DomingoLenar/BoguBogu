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

    // Helper method to hash a string using SHA-256
/**
*1. Initialize a MessageDigest object with the "SHA-256" algorithm.
*2. Get the bytes of the input string `toHash`.
*3. Compute the hash of the input bytes using MessageDigest.
*4. Convert the hash bytes to a hexadecimal string.
*5. Return the hexadecimal hash string.
*/

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

    // Set the hashed password
/**
1. Call `hashString(password)` to hash the input password.
2. Store the hashed password in the `password` field.
*/

    public void setPassword(String password) {
        this.password = hashString(password);
    }

    // Validate user password
/**
1. Create a `FileHandling` object.
2. Create a `File` object representing the user's credentials file.
3. Create a `Scanner` to read the credentials file.
4. Read the stored credentials from the file.
5. Compare the hashed password with the stored hashed password.
6. Return `true` if they match; otherwise, return `false`.
*/
    public boolean isPassValid() throws FileNotFoundException {
        FileHandling handler = new FileHandling();
        File creds = new File("PrelimProj2/src/data/" + username + "/credentials.txt");
        Scanner in = new Scanner(creds);
        String[] data = in.nextLine().split(",");
        return (password.equals(data[1]));
    }

    // Getters and setters for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Create a user file and directory
/**
1. Create a `FileHandling` object.
2. Define the path to the user's folder based on the username.
3. Check if the user's folder already exists.
4. If not, create the user's folder.
5. Create a `File` object for the credentials file.
6. If the credentials file doesn't exist, create it.
7. Write the username and hashed password to the credentials file.
*/
    public void createUserFile() {
        FileHandling fileHandler = new FileHandling();
        String userFolder = "PrelimProj2/src/data/" + username;
        if (!fileHandler.directoryExists(userFolder)) {
            try {
                fileHandler.createDirectory(userFolder);
            } catch (Exception directoryCreation) {
                directoryCreation.printStackTrace();
            }
        }
        try {
            File file = new File(userFolder + "/credentials.txt");
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

    // Fetch emails from a file
/**
1. Create a `File` object representing the user's mailbox file of the specified type (e.g., inbox or sent).
2. Create a `Scanner` to read the mailbox file.
3. Initialize variables for storing email details.
4. Create a list of email threads (`listOfThreads`) to store email conversations.
5. Loop through each line in the mailbox file.
6. Parse email details (sender, receiver, subject, and body).
7. Group emails into threads based on the subject.
8. Return the list of email threads.
*/
    public SingleLinkedList<SingleLinkedList<Email>> fetchMails(String type, String username) {
        Scanner dataScanner = null;
        SingleLinkedList<Email> thread = new SingleLinkedList<>();
        SingleLinkedList<SingleLinkedList<Email>> listOfThreads = new SingleLinkedList<>();
        File data = new File("PrelimProj2/src/data/" + username + "/" + type + ".txt");
        try {
            dataScanner = new Scanner(data);
        } catch (FileNotFoundException fNFE) {
            fNFE.printStackTrace();
        }
        String currentS = null;
        while (dataScanner.hasNext()) {
            String[] rawData = dataScanner.nextLine().split(",");
            String sender, receiver, subject, body;
            sender = rawData[0];
            receiver = rawData[1];
            subject = rawData[2];
            body = rawData[3];
            Email mail = new Email(sender, receiver, subject, body);
            if (!subject.equals(currentS) || currentS == null) {
                thread.add(mail);
                currentS = subject;
            } else {
                listOfThreads.add(thread);
                currentS = subject;
                thread = null;
                thread.add(mail);
            }
        }
        return listOfThreads;
    }

    // Save runtime mails to files
/**
1. Create a `FileHandling` object.
2. Check if the user's directory exists.
3. Create `File` objects for the inbox and sent mailbox files.
4. Create `PrintWriter` objects to write to the inbox and sent mailbox files.
5. Iterate through each email thread in `listOfThreads`.
6. Iterate through each email in the thread.
7. Write email details to the inbox file.
8. If the email sender is the user, write the email to the sent file as well.
9. Close the inbox and sent files.
*/
    public void saveRuntimeMails(SingleLinkedList<SingleLinkedList<Email>> listOfThreads, String type, String username) {
        FileHandling handler = new FileHandling();
        if (handler.directoryExists("PrelimProj2/src/data/" + username)) {
            File inboxFile = new File("PrelimProj2/src/data/" + username + "/" + type + ".txt");
            File sentFile = new File("PrelimProj2/src/data/" + username + "/sent.txt");
            try {
                PrintWriter inboxOutput = new PrintWriter(inboxFile);
                PrintWriter sentOutput = new PrintWriter(sentFile);
                if (inboxFile.exists()) {
                    SingleNode<SingleLinkedList<Email>> currentThreadNode = listOfThreads.getHead();
                    SingleNode<Email> threadPointer = currentThreadNode.getData().getHead();
                    for (int x = 0; x < listOfThreads.getSize(); x++) {
                        for (int y = 0; y < currentThreadNode.getData().getSize(); y++) {
                            inboxOutput.println(threadPointer.getData().toString());
                            inboxOutput.flush();
                            if (threadPointer.getData().getSender().equals(username)) {
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
            } catch (FileNotFoundException outputError) {
                outputError.printStackTrace();
            }
        }
    }

    // Update email threads of the receiver
/**
1. Fetch the existing email threads for the receiver using `fetchMails`.
2. Iterate through the existing email threads.
3. Find the thread with a matching subject to the input `thread`.
4. Update the email thread with the new emails.
5. Save the updated email threads using `saveRuntimeMails`.
*/
    public void updateThreadOfReceiver(SingleLinkedList<Email> thread, String receiver) {
        SingleLinkedList<SingleLinkedList<Email>> listOfThreads = fetchMails("inbox", receiver);
        SingleNode<SingleLinkedList<Email>> pointer = listOfThreads.getHead();
        SingleNode<Email> iP;
        SingleNode<Email> inputPointer = thread.getHead();
        while (pointer.getLink() != null) {
            if (pointer.getData().getHead().getData().getSubject().equals(thread.getHead().getData().getSubject())) {
                iP = pointer.getData().getHead();
                while (inputPointer.getLink() != null) {
                    if (iP.getLink() != null) {
                        iP.setData(inputPointer.getData());
                        iP = iP.getLink();
                    } else {
                        iP.setLink(inputPointer);
                    }
                    inputPointer = inputPointer.getLink();
                }
            }
        }
        saveRuntimeMails(listOfThreads, "inbox", receiver);
    }

    public static void main(String[] args) {
        // Test the User class by creating a user file
        User testUser = new User("Lestat", "Lestat10");
        testUser.createUserFile();
    }
}
