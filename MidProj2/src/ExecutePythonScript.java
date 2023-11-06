import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecutePythonScript {
    public static void main(String[] args) {
        try {
            // Path to the virtual environment's Python executable
            String pythonExecutable = "MidProj2/PythonScripts/venv/Scripts/python.exe"; // Replace with the actual path

            // Path to the Python script you want to run
            String pythonScript = "MidProj2/PythonScripts/GenerateTreeImage.py"; // Replace with the actual path

            // Create a ProcessBuilder for the Python script within the virtual environment
            ProcessBuilder processBuilder = new ProcessBuilder(pythonExecutable, pythonScript);

            // Start the process
            Process process = processBuilder.start();

            // Read the output of the Python script
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the Python script to finish
            int exitCode = process.waitFor();
            System.out.println("Python script exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}