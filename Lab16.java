import java.io.*;

public class Lab16 {
    
    public static void main(String[] args) {
        System.out.println("=== LAB 16: FILE OPERATIONS & I/O EXCEPTIONS ===\n");
        
        // PART 1: Gaming - Game Save System (Writing Operations)
        part1();
        
        // PART 2: Business - Employee Management (Reading & File Management)
        part2();
    }
    
    /**
     * PART 1: Gaming - Game Save System
     * Practice: File creation, FileWriter, BufferedWriter, appending, directory management
     */
    public static void part1() {
        System.out.println("--- Part 1: Game Save System ---");
        GameSaveManager saveManager = new GameSaveManager();
        
        String playerData = "PlayerName:Legolas|Level:45|Gold:5000|Location:Rivendell";
        String filename = "saves/game_save.txt";
        
        saveManager.createSaveDirectory();
        saveManager.savePlayerData(playerData, filename);
        saveManager.appendGameLog(filename, "Defeated dragon at Mountain Pass");
        
        System.out.println();
    }
    
    /**
     * PART 2: Business - Employee Management
     * Practice: File existence, FileReader, BufferedReader, file deletion, directory listing
     */
    public static void part2() {
        System.out.println("--- Part 2: Employee Management System ---");
        
        try {
            __________________________________;  // Call EmployeeManager.manageEmployeeFiles()
            
        } catch (FileNotFoundException e) {
            __________________________________;  // Catch FileNotFoundException
            
        } catch (IOException e) {
            __________________________________;  // Catch IOException
        }
    }
}

/**
 * PART 1: GameSaveManager Class
 * Practice file operations: create directory, write files, append data, try-catch-finally
 */
class GameSaveManager {
    private boolean operationSuccessful = false;
    
    /**
     * TODO: Add try-catch-finally
     * Try: 
     *   - Create File object for "saves" directory
     *   - Use .mkdir() to create the directory
     *   - Print success message
     * Catch IOException: Print error message
     * Finally: Print status
     */
    public void createSaveDirectory() {
        _________________________________  // TODO: Add try
        {
            File saveDir = new File("saves");
            
            if (!_________________________________ ) {  // TODO: Check if directory exists using .exists()
                saveDir.mkdir();
                System.out.println("✓ Save directory created!");
            } else {
                System.out.println("✓ Save directory already exists");
            }
            operationSuccessful = true;
            
        } _________________________________  // TODO: Catch IOException
        {
            System.out.println("✗ Error creating directory: " + e.getMessage());
            operationSuccessful = false;
            
        } _________________________________  // TODO: Finally block
        {
            System.out.println("[Status] Directory: " + (operationSuccessful ? "✓ SUCCESS" : "✗ FAILED"));
        }
    }
    
    /**
     * TODO: Add try-catch-finally
     * Try:
     *   - Create File object
     *   - Use .createNewFile() to create the file
     *   - Create FileWriter to write data
     *   - Write header and player data
     *   - Use BufferedWriter for efficient writing (wrap FileWriter)
     *   - Close the writer
     * Catch FileNotFoundException: Print error
     * Catch IOException: Print error
     * Finally: Print status
     */
    public void savePlayerData(String playerData, String filename) {
        operationSuccessful = false;
        
        _________________________________  // TODO: Add try
        {
            File saveFile = new File(filename);
            saveFile.createNewFile();  // Create the file if it doesn't exist
            
            FileWriter writer = new FileWriter(saveFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write("=== GAME SAVE DATA ===\n");
            bufferedWriter.write(playerData);
            bufferedWriter.newLine();
            
            bufferedWriter.close();
            writer.close();
            
            System.out.println("✓ Game saved successfully to " + filename);
            operationSuccessful = true;
            
        } _________________________________  // TODO: Catch FileNotFoundException
        {
            System.out.println("✗ Error: Invalid file path. Cannot save game.");
            operationSuccessful = false;
            
        } _________________________________  // TODO: Catch IOException
        {
            System.out.println("✗ Error: Write operation failed. " + e.getMessage());
            operationSuccessful = false;
            
        } _________________________________  // TODO: Finally block
        {
            System.out.println("[Status] Save: " + (operationSuccessful ? "✓ SUCCESS" : "✗ FAILED"));
        }
    }
    
    /**
     * TODO: Add try-catch-finally
     * Try:
     *   - Create FileWriter with APPEND MODE (second parameter = true)
     *   - Write the game log entry
     *   - Close the writer
     * Catch IOException: Print error
     * Finally: Print status
     * 
     * Note: Append mode = true allows adding data without overwriting
     */
    public void appendGameLog(String filename, String logEntry) {
        operationSuccessful = false;
        
        _________________________________  // TODO: Add try
        {
            FileWriter writer = new FileWriter(filename, __________);  // TODO: true for append mode
            
            writer.write("\n[LOG] " + logEntry);
            writer.close();
            
            System.out.println("✓ Log entry added: " + logEntry);
            operationSuccessful = true;
            
        } _________________________________  // TODO: Catch IOException
        {
            System.out.println("✗ Error: Could not append log. " + e.getMessage());
            operationSuccessful = false;
            
        } _________________________________  // TODO: Finally block
        {
            System.out.println("[Status] Append: " + (operationSuccessful ? "✓ SUCCESS" : "✗ FAILED"));
        }
    }
}

/**
 * PART 2: EmployeeManager Class
 * Practice: File existence, FileReader, BufferedReader, file deletion, directory listing, throws
 */
class EmployeeManager {
    
    /**
     * TODO: Add throws to method signature
     * throws FileNotFoundException, IOException
     * 
     * Tasks:
     * 1. Check if "employees" directory exists using .exists()
     * 2. If not, create it with .mkdir()
     * 3. Check if "employees/employee_data.txt" exists
     * 4. Read the file using FileReader and BufferedReader
     * 5. Print first line using .readLine()
     * 6. List all files in "employees" directory using .listFiles()
     * 7. Print each filename
     * 8. Optionally delete a backup file if it exists
     * 
     * Let exceptions propagate - don't catch them here
     */
    public static void manageEmployeeFiles(String filename) _______________ {
        
        // Check and create employees directory
        File empDir = new File("employees");
        if (!___________________________________) {  // TODO: Check if directory exists
            empDir.mkdir();
            System.out.println("✓ Created employees directory");
        }
        
        // Check if file exists
        File empFile = new File(filename);
        if (!___________________________________) {  // TODO: Use .exists() to check
            throw new FileNotFoundException("Employee file not found: " + filename);
        }
        
        System.out.println("✓ Employee file found!");
        
        // Read file using FileReader and BufferedReader
        FileReader reader = new FileReader(empFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        
        String firstLine = _________________________________;  // TODO: Use .readLine()
        System.out.println("✓ First employee record: " + firstLine);
        
        bufferedReader.close();
        reader.close();
        
        // List all files in directory
        File[] files = empDir.listFiles();
        System.out.println("✓ Files in employees directory:");
        if (files != null) {
            for (File file : files) {
                System.out.println("  - " + file.getName());
            }
        }
        
        // Delete backup file if it exists
        File backup = new File("employees/employee_backup.txt");
        if (___________________________________) {  // TODO: Check if backup exists
            backup.delete();
            System.out.println("✓ Old backup deleted");
        }
    }
}
