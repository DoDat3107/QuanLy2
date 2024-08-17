package saveData;

import model.Clazz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteClazz {
    private File file = new File("database/clazz.csv");

    public void writeData(List<Clazz> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.file))) {
            for (Clazz item : list) {
                bufferedWriter.write(item.getId() + "," + item.getName() + "," + item.getKhoi() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace(); // In ra lỗi để dễ theo dõi
        }
    }

    public List<Clazz> readData() {
        List<Clazz> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",", -1);
                if (data.length == 3) {
                    Clazz c = new Clazz(Integer.parseInt(data[0]), data[1], data[2]);
                    list.add(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
