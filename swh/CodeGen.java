package swh;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CodeGen {

  public static void main(String[] args) {
    System.out.println("Codegen called");
    String outPath = args[1];
    System.out.println("Outpath: " + outPath);

    Path currentWorkingDirectory = Paths.get("");
    String directoryPath = currentWorkingDirectory.toAbsolutePath().toString();
    System.out.println("Current working directory: " + directoryPath);

    String fileContent = "public class SampleGeneratedCode {}";

    try {
      Path path = Paths.get(outPath);
      Files.write(path, fileContent.getBytes(StandardCharsets.UTF_8));
      System.out.println("File successfully written");

    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
    System.exit(0);
  }
}
