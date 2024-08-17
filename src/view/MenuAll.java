package view;

import input.Input;

public class MenuAll {
    ClazzMenu clazzMenu = new ClazzMenu();
    StudentMenu studentMenu = new StudentMenu();

    public void selecMenu() {

        int choice;
        do {
            System.out.println("=======Menu=======");
            System.out.println("1. Quan ly sinh viên");
            System.out.println("2. Quan ly Clazz ");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn : ");
            choice = Input.inputNumber();

            switch (choice) {
                case 1:
                    studentMenu.showMainStudentMenu();
                    break;
                case 2:
                    clazzMenu.showMainClazzMenu();
                    break;

            }
        } while (choice != 0);
    }
}

