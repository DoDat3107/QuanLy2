package saveData;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadAndWriteStudent {
    private File file = new File("database/student.csv");

    public void writeData(List<Student> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.file))) {
            for (Student item : list) {
                String scores = Arrays.stream(item.getScore())
                        .mapToObj(String::valueOf)
                        .reduce((s1, s2) -> s1 + ";" + s2)
                        .orElse("");
                bufferedWriter.write(item.getId() + "," +
                        item.getName() + "," +
                        scores + "," +
                        item.getGender() + "," +
                        item.getHanhKiem() + "," +
                        item.getClazzId() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> readData() {
        List<Student> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",", -1);
                if (data.length == 6) {
                    double[] scores = Arrays.stream(data[2].split(";"))
                            .mapToDouble(Double::parseDouble)
                            .toArray();
                    Student c = new Student(Integer.parseInt(data[0]), data[1], scores, data[3], data[4], Integer.parseInt(data[5]));
                    list.add(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
