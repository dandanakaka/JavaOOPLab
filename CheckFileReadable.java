
import java.io.File;
class CheckFileReadable {
    public static void main(String[] args) {
        String filePath = "example.txt";
        
        File file = new File(filePath);
        
        if (file.exists()) {
            System.out.println("File exists: " + file.getAbsolutePath());
            
            if (file.canRead()) {
                System.out.println("File can be read: YES");
                System.out.println("File is readable and you have read permissions.");
            } else {
                System.out.println("File can be read: NO");
                System.out.println("You don't have read permissions for this file.");
            }
            
            System.out.println("\nAdditional Information:");
            System.out.println("Can Write: " + (file.canWrite() ? "YES" : "NO"));
            System.out.println("Can Execute: " + (file.canExecute() ? "YES" : "NO"));
            System.out.println("Is File: " + (file.isFile() ? "YES" : "NO"));
            System.out.println("Is Directory: " + (file.isDirectory() ? "YES" : "NO"));
            
        } else {
            System.out.println("File does not exist at: " + filePath);
        }
    }
}
