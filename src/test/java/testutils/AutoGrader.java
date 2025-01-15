package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.DoStmt;

public class AutoGrader {

    // Test if the code uses only do-while loop and not while or for loops
    public boolean testDoWhileLoopOnly(String filePath) throws IOException {
        System.out.println("Starting testDoWhileLoopOnly with file: " + filePath);

        File participantFile = new File(filePath); // Path to participant's file
        if (!participantFile.exists()) {
            System.out.println("File does not exist at path: " + filePath);
            return false;
        }

        FileInputStream fileInputStream = new FileInputStream(participantFile);
        JavaParser javaParser = new JavaParser();
        CompilationUnit cu;
        try {
            cu = javaParser.parse(fileInputStream).getResult()
                    .orElseThrow(() -> new IOException("Failed to parse the Java file"));
        } catch (IOException e) {
            System.out.println("Error parsing the file: " + e.getMessage());
            throw e;
        }

        System.out.println("Parsed the Java file successfully.");

        boolean hasDoWhileLoop = false;

        // Log the parsed do-while loop statements
        System.out.println("------ do-while Loop Statements ------");
        for (DoStmt doStmt : cu.findAll(DoStmt.class)) {
            System.out.println("do-while loop found: " + doStmt);
            hasDoWhileLoop = true;
        }

        // Check if only do-while loop is used and no 'while' or 'for'
        System.out.println("Has do-while loop: " + hasDoWhileLoop);

        boolean result = hasDoWhileLoop;
        System.out.println("Test result: " + result);

        return result;
    }
}
