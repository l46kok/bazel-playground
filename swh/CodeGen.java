package swh;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CodeGen {

  public static void main(String[] args) throws IOException {
    System.out.println("Codegen called");
    String outPath = args[0];
    System.out.println("Outpath: " + outPath);
    String packageName = args[1];
    System.out.println("Package: " + packageName);

    Path currentWorkingDirectory = Paths.get("");
    String directoryPath = currentWorkingDirectory.toAbsolutePath().toString();

    System.out.println("Current working directory: " + directoryPath);

    String fileContent = "package " + packageName + ";\n"
        + "        \n"
        + "        public class SampleGeneratedCode {\n"
        + "          public static String getFoo() {\n"
        + "            return \" " + packageName + "\";\n"
        + "          }\n"
        + "        }";
    String zipOutfile = outPath;
    String javaFileName = "SampleGeneratedCode.java";
    zip(zipOutfile, javaFileName, fileContent);

    System.exit(0);
  }

  public static void zip(String zipFileName, String entryName, String content) throws IOException {
    try (FileOutputStream fos = new FileOutputStream(zipFileName);
        ZipOutputStream zos = new ZipOutputStream(fos)) {

      // Create a new ZipEntry for the file
      ZipEntry entry = new ZipEntry(entryName);
      zos.putNextEntry(entry);

      // Convert the string content to an input stream
      try (InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))) {
        // Write the content of the input stream to the zip output stream
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
          zos.write(buffer, 0, length);
        }
      }

      // Close the current entry
      zos.closeEntry();
    }
  }
}
