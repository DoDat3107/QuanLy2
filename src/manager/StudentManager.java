package manager;

import model.Student;
import saveData.ReadAndWriteStudent;

import java.util.*;

public class StudentManager implements IManager<Student> {
    private List<Student> list;
    private ReadAndWriteStudent readAndWriteStudent = new ReadAndWriteStudent();

    public StudentManager() {
        this.list = readAndWriteStudent.readData();
    }

    @Override
    public void add(Student student) {
        this.list.add(student);
        Collections.sort(this.list, Comparator.comparing(Student::getName));
        readAndWriteStudent.writeData(this.list);
    }

    @Override
    public void delete(int id) {
        int index = this.findById(id);
        if (index != -1) {
            this.list.remove(index);
            readAndWriteStudent.writeData(this.list);
        }
    }

    @Override
    public void update(int id, Student student) {
        int index = this.findById(id);
        if (index != -1) {
            this.list.set(index, student);
            readAndWriteStudent.writeData(this.list);
        }
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(this.list);
    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < this.list.size(); i++) {
            if (id == this.list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public List<Student> findByScoreRange(double minScore, double maxScore) {
        List<Student> result = new ArrayList<>();
        for (Student student : list) {
            double avgScore = Arrays.stream(student.getScore()).average().orElse(0);
            if (avgScore >= minScore && avgScore <= maxScore) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> findByHanhKiem(String hanhKiem) {
        List<Student> result = new ArrayList<>();
        for (Student student : list) {
            if (hanhKiem.equals(student.getHanhKiem())) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> findByClazz(int clazzId) {
        List<Student> result = new ArrayList<>();
        for (Student student : list) {
            if (clazzId == student.getClazzId()) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> findMaxScore() {
        List<Student> result = new ArrayList<>();
        double maxScore = Double.MIN_VALUE;
        for (Student student : list) {
            double avgScore = Arrays.stream(student.getScore()).average().orElse(Double.MIN_VALUE);
            if (avgScore > maxScore) {
                maxScore = avgScore;
            }
        }
        for (Student student : list) {
            double avgScore = Arrays.stream(student.getScore()).average().orElse(Double.MIN_VALUE);
            if (avgScore == maxScore) {
                result.add(student);
            }
        }
        return result;
    }

    public void sortByName() {
        Collections.sort(this.list, Comparator.comparing(Student::getName));
        readAndWriteStudent.writeData(this.list);
    }
}
