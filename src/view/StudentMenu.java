package view;

import input.Input;
import manager.StudentManager;
import manager.ClazzManager;
import model.Clazz;
import model.Student;

import java.util.Arrays;
import java.util.List;

public class StudentMenu {
    private StudentManager studentManager = new StudentManager();
    private ClazzManager clazzManager = new ClazzManager();

    public void showMainStudentMenu() {
        int choice;
        do {
            System.out.println("========= Menu Sinh Viên ============");
            System.out.println("1. Thêm mới Sinh Viên");
            System.out.println("2. Sửa Sinh Viên");
            System.out.println("3. Xóa Sinh Viên");
            System.out.println("4. Hiển thị tất cả Sinh Viên");
            System.out.println("5. Tìm kiếm theo khoảng điểm");
            System.out.println("6. Tìm kiếm theo hạnh kiểm");
            System.out.println("7. Tìm kiếm theo lớp");
            System.out.println("8. Tìm sinh viên có điểm cao nhất");
            System.out.println("9. Sắp xếp danh sách sinh viên");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chọn: ");
            choice = Input.inputNumber();
            switch (choice) {
                case 1:
                    showAddMenu();
                    break;
                case 2:
                    showEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showPaginatedList();
                    break;
                case 5:
                    showFindByScoreRangeMenu();
                    break;
                case 6:
                    showFindByHanhKiemMenu();
                    break;
                case 7:
                    showFindByClazzMenu();
                    break;
                case 8:
                    showFindMaxScoreMenu();
                    break;
                case 9:
                    showSortMenu();
                    break;
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("=========== Thêm Sinh Viên ============");
        System.out.println("Nhập tên sinh viên: ");
        String name = Input.inputString();
        System.out.println("Nhập điểm sinh viên (cách nhau bởi dấu phẩy): ");
        String[] scoresInput = Input.inputString().split(",");
        double[] scores = Arrays.stream(scoresInput).mapToDouble(Double::parseDouble).toArray();
        System.out.println("Nhập giới tính sinh viên: ");
        String gender = Input.inputString();
        System.out.println("Nhập hạnh kiểm sinh viên: ");
        String hanhKiem = Input.inputString();
        System.out.println("Danh sách lớp:");
        List<Clazz> clazzList = clazzManager.getAll();
        for (int i = 0; i < clazzList.size(); i++) {
            System.out.println(i + 1 + ". " + clazzList.get(i).getName()+". "+clazzList.get(i).getKhoi());
        }
        System.out.println("Vui lòng chọn lớp: ");
        int choiceIndexCate = Input.inputNumber();
        int clazzId = clazzList.get(choiceIndexCate - 1).getId();
        Student student = new Student(name, scores, gender, hanhKiem, clazzId);
        studentManager.add(student);
        System.out.println("Thêm sinh viên thành công");
    }

    public void showEdit() {
        System.out.println("========== Sửa Sinh Viên ========== ");
        System.out.println("Nhập ID của sinh viên muốn sửa: ");
        int idEdit = Input.inputNumber();
        System.out.println("Nhập tên mới: ");
        String name = Input.inputString();
        System.out.println("Nhập điểm mới (cách nhau bởi dấu phẩy): ");
        String[] scoresInput = Input.inputString().split(",");
        double[] scores = Arrays.stream(scoresInput).mapToDouble(Double::parseDouble).toArray();
        System.out.println("Nhập giới tính mới: ");
        String gender = Input.inputString();
        System.out.println("Nhập hạnh kiểm mới: ");
        String hanhKiem = Input.inputString();
        System.out.println("Danh sách lớp:");
        List<Clazz> clazzList = clazzManager.getAll();
        for (int i = 0; i < clazzList.size(); i++) {
            System.out.println(i + 1 + ". " + clazzList.get(i).getName());
        }
        System.out.println("Vui lòng chọn lớp: ");
        int choiceIndexCate = Input.inputNumber();
        int clazzId = clazzList.get(choiceIndexCate - 1).getId();
        Student student = new Student(idEdit, name, scores, gender, hanhKiem, clazzId);
        studentManager.update(idEdit, student);
        System.out.println("Cập nhật thông tin sinh viên thành công.");
    }

    public void showMenuRemove() {
        System.out.println("========== Xóa Sinh Viên ========== ");
        System.out.println("Nhập ID sinh viên cần xóa: ");
        int idRemove = Input.inputNumber();
        studentManager.delete(idRemove);
        System.out.println("Xóa sinh viên thành công.");
    }

    public void showPaginatedList() {
        List<Student> students = studentManager.getAll();
        int pageSize = 5;
        int totalPages = (int) Math.ceil((double) students.size() / pageSize);
        int currentPage = 0;

        while (currentPage < totalPages) {
            int start = currentPage * pageSize;
            int end = Math.min(start + pageSize, students.size());
            System.out.println("Danh sách sinh viên (Trang " + (currentPage + 1) + " / " + totalPages + "):");
            for (int i = start; i < end; i++) {
                System.out.println(students.get(i));
            }
            currentPage++;
            if (currentPage < totalPages) {
                System.out.println("Nhấn Enter để xem trang tiếp theo hoặc nhập '0' để quay lại menu.");
                String input = Input.inputString();
                if ("0".equals(input)) {
                    break;
                }
            }
        }
    }

    public void showFindByScoreRangeMenu() {
        System.out.println("Nhập điểm thấp nhất: ");
        double minScore = Input.inputNumber();
        System.out.println("Nhập điểm cao nhất: ");
        double maxScore = Input.inputNumber();
        List<Student> students = studentManager.findByScoreRange(minScore, maxScore);
        displayStudents(students);
    }

    public void showFindByHanhKiemMenu() {
        System.out.println("Nhập hạnh kiểm cần tìm: ");
        String hanhKiem = Input.inputString();
        List<Student> students = studentManager.findByHanhKiem(hanhKiem);
        displayStudents(students);
    }

    public void showFindByClazzMenu() {
        System.out.println("Danh sách lớp:");
        List<Clazz> clazzList = clazzManager.getAll();
        for (int i = 0; i < clazzList.size(); i++) {
            System.out.println(i + 1 + ". " + clazzList.get(i).getName());
        }
        System.out.println("Vui lòng chọn lớp: ");
        int choiceIndexCate = Input.inputNumber();
        int clazzId = clazzList.get(choiceIndexCate - 1).getId();
        List<Student> students = studentManager.findByClazz(clazzId);
        displayStudents(students);
    }

    public void showFindMaxScoreMenu() {
        List<Student> students = studentManager.findMaxScore();
        displayStudents(students);
    }

    public void showSortMenu() {
        studentManager.sortByName();
        System.out.println("Danh sách sinh viên đã được sắp xếp theo tên.");
        List<Student> students = studentManager.getAll();
        displayStudents(students);
    }

    private void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
