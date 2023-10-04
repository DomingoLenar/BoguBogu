import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main implements Runnable{
    public static void main(String[] args) {
        Main obj = new Main();
        try {
            obj.run();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            new EmailServiceInterface();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

}
