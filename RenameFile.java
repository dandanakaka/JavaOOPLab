import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

class RenameFile {
    public static void main(String[] args) {
        String oldName = "example.txt";
        String newName = "newfile.txt";

        // allow overriding via command-line args: java RenameFile source dest
        if (args.length >= 2) {
            oldName = args[0];
            newName = args[1];
        }

        Path oldPath = Paths.get(oldName);
        Path newPath = Paths.get(newName);

        if (!Files.exists(oldPath)) {
            System.out.println("Source file does not exist: " + oldName);
            return;
        }

        try {
            // Use REPLACE_EXISTING if you want to overwrite existing target
            Files.move(oldPath, newPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed successfully!");
            System.out.println("Old name: " + oldName);
            System.out.println("New name: " + newName);
        } catch (Exception e) {
            System.out.println("Failed to rename the file.");
            System.out.println("Reason: " + e.getMessage());
            // Optionally print stack trace for debugging:
            // e.printStackTrace();
        }
    }
}