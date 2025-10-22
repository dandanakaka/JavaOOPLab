import java.io.*;

class CheckFileExists {
    public static void main(String[] args) {
        String filePath = "example.txt";
        
        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            
            System.out.println("File found at: " + file.getAbsolutePath());
            fis.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found at specified location!");
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error closing file: " + e.getMessage());
        }
    }
}