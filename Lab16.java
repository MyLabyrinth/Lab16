// ============================================
// LAB 16: File Operations & I/O Exceptions
// Two systems: Game Saves + Employee Management
// ============================================

// ============================================
// TODO: Add all packages required by the code below
// ============================================


public class Lab16 {
    
    public static void main(String[] args) {
        System.out.println("=== LAB 16: FILE OPERATIONS & I/O EXCEPTIONS ===\n");
        
        // PART 1: Gaming — Game Save System (write-heavy)
        part1();
        
        // PART 2: Business — Employee Management (read-heavy)
        part2();
    }
    
    /**
     * PART 1: Game Save System
     * Practices: file creation, writing, appending, directory setup, try-catch-finally
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
     * PART 2: Employee Management System
     * Practices: file existence, reading, directory listing, deletion, exception propagation
     */
    public static void part2() {
        System.out.println("--- Part 2: Employee Management System ---");
        
        try {
            // TODO: Run the employee-management routine for the employee data file
            __________________________________;
            
        } catch (FileNotFoundException e) {
            // TODO: Respond when the employee file cannot be found
            __________________________________;
            
        } catch (IOException e) {
            // TODO: Respond to any other I/O failure
            __________________________________;
        }
    }
}

/**
 * PART 1: GameSaveManager
 * Handles all write-side operations for the save system
 */
class GameSaveManager {
    private boolean operationSuccessful = false;
    
    /**
     * Ensure the save directory is available on disk, creating it only when absent.
     * Report the final status before returning.
     */
    public void createSaveDirectory() {
        // TODO: Wrap the work below in the appropriate exception-handling structure:
        //   - Attempt the directory setup
        //   - Recover from any I/O failure
        //   - Always print the status line at the end
        
        _________________________________
        {
            File saveDir = new File("saves");
            
            // TODO: Only create the directory when one is not already present
            if (!_________________________________ ) {
                saveDir.mkdir();
                System.out.println("✓ Save directory created!");
            } else {
                System.out.println("✓ Save directory already exists");
            }
            operationSuccessful = true;
            
        } _________________________________
        {
            System.out.println("✗ Error creating directory: " + e.getMessage());
            operationSuccessful = false;
            
        } _________________________________
        {
            System.out.println("[Status] Directory: " + (operationSuccessful ? "✓ SUCCESS" : "✗ FAILED"));
        }
    }
    
    /**
     * Save the player's data to a file.
     * Write a header line, then the player data itself.
     * Distinguish a missing-file failure from any other I/O failure.
     * Always report status.
     */
    public void savePlayerData(String playerData, String filename) {
        operationSuccessful = false;
        
        // TODO: Wrap the work below in exception handling:
        //   - One recovery path for a missing file
        //   - One recovery path for any other I/O failure
        //   - A status report that always runs at the end
        
        _________________________________
        {
            File saveFile = new File(filename);
            saveFile.createNewFile();
            
            FileWriter writer = new FileWriter(saveFile);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write("=== GAME SAVE DATA ===\n");
            bufferedWriter.write(playerData);
            bufferedWriter.newLine();
            
            bufferedWriter.close();
            writer.close();
            
            System.out.println("✓ Game saved successfully to " + filename);
            operationSuccessful = true;
            
        } _________________________________
        {
            System.out.println("✗ Error: Invalid file path. Cannot save game.");
            operationSuccessful = false;
            
        } _________________________________
        {
            System.out.println("✗ Error: Write operation failed. " + e.getMessage());
            operationSuccessful = false;
            
        } _________________________________
        {
            System.out.println("[Status] Save: " + (operationSuccessful ? "✓ SUCCESS" : "✗ FAILED"));
        }
    }
    
    /**
     * Add a log entry to an existing save file without losing any of the existing contents.
     * Always report status.
     */
    public void appendGameLog(String filename, String logEntry) {
        operationSuccessful = false;
        
        // TODO: Wrap the work below in exception handling (attempt, recover, report)
        
        _________________________________
        {
            // TODO: Open a writer configured so that existing data in the file is preserved
            FileWriter writer = new FileWriter(filename, __________);
            
            writer.write("\n[LOG] " + logEntry);
            writer.close();
            
            System.out.println("✓ Log entry added: " + logEntry);
            operationSuccessful = true;
            
        } _________________________________
        {
            System.out.println("✗ Error: Could not append log. " + e.getMessage());
            operationSuccessful = false;
            
        } _________________________________
        {
            System.out.println("[Status] Append: " + (operationSuccessful ? "✓ SUCCESS" : "✗ FAILED"));
        }
    }
}

/**
 * PART 2: EmployeeManager
 * Handles reads, directory listing, and cleanup
 */
class EmployeeManager {
    
    /**
     * Manage the employee files for the given path:
     *   - Ensure the employees directory is set up
     *   - Read the employee file and display the first record
     *   - List every file in the employees directory
     *   - Remove any leftover backup file
     * Let exceptions bubble up to the caller instead of handling them here.
     */
    // TODO: Declare that this method can propagate file- and I/O-related exceptions
    public static void manageEmployeeFiles(String filename) _______________ {
        
        // Set up the employees directory
        File empDir = new File("employees");
        // TODO: Create the directory only when one is not already present
        if (!___________________________________) {
            empDir.mkdir();
            System.out.println("✓ Created employees directory");
        }
        
        // Verify the employee file is on disk before reading
        File empFile = new File(filename);
        // TODO: Trigger the missing-file signal when the employee file is not there
        if (!___________________________________) {
            throw new FileNotFoundException("Employee file not found: " + filename);
        }
        
        System.out.println("✓ Employee file found!");
        
        // Open the file for reading, wrapped for line-level access
        FileReader reader = new FileReader(empFile);
        BufferedReader bufferedReader = new BufferedReader(reader);
        
        // TODO: Pull the first line out of the file
        String firstLine = _________________________________;
        System.out.println("✓ First employee record: " + firstLine);
        
        bufferedReader.close();
        reader.close();
        
        // List every file in the employees directory
        File[] files = empDir.listFiles();
        System.out.println("✓ Files in employees directory:");
        if (files != null) {
            for (File file : files) {
                System.out.println("  - " + file.getName());
            }
        }
        
        // Clean up any leftover backup
        File backup = new File("employees/employee_backup.txt");
        // TODO: Only attempt removal when a backup is actually present
        if (___________________________________) {
            backup.delete();
            System.out.println("✓ Old backup deleted");
        }
    }
}
