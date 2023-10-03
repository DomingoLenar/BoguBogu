
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
        new EmailServiceInterface();
    }

}
