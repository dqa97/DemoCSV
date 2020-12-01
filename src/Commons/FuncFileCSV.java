package Commons;

import Models.Students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncFileCSV {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR= "\n";
    private static final String fileNameStudent= "Src/Data/student.csv";
    private static final String FILE_HEADER = "name,grade,address";

    public static void writeStudentToFileCSV(ArrayList<Students> ListStudents){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameStudent);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Students students : ListStudents){
                fileWriter.append(students.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(students.getGrade());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(students.getAddress());
                fileWriter.append(NEW_LINE_SEPARATOR);

            }

        } catch (Exception e){
            System.out.println("Error in CSV file writer !");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception exception){
                System.out.println("Error when flush or close");
            }

        }
    }
    public static ArrayList<Students> getFileCVSToListStudent(){
        BufferedReader bufferedReader = null;
        ArrayList<Students> listStudent = new ArrayList<Students>();
        Path path = Paths.get(fileNameStudent);
        if (!Files.exists(path)){
            try {
                Writer writer = new FileWriter(fileNameStudent);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            bufferedReader = new BufferedReader(new FileReader(fileNameStudent));

            while ((line = bufferedReader.readLine())!=null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("name")) {
                    continue;
                }
                Students students = new Students();
                students.setName(splitData[0]);
                students.setGrade(splitData[1]);
                students.setAddress(splitData[2]);
                listStudent.add(students);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return listStudent;
    }
}
