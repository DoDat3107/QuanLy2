package view;

import input.Input;
import manager.ClazzManager;
import model.Clazz;

import java.util.List;

public class ClazzMenu {
    private ClazzManager clazzManager = new ClazzManager();
    public void showMainClazzMenu() {
        int choice;
        do {
            System.out.println("========= Menu Clazz ============");
            System.out.println("1. Thêm mới Clazz");
            System.out.println("2. Sua Clazz");
            System.out.println("3. Xoa Clazz");
            System.out.println("4. Hiển thị tất cả ");
            System.out.println("0. Thoát");
            System.out.println("Vui lòng nhập lựa chon: ");
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
                    showAllMenu();
                    break;
            }
        } while (choice != 0);
    }

    public void showAddMenu() {
        System.out.println("========== Thêm Clazz ========== ");
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        System.out.println("Nhập Khoi: ");
        String Khoi = Input.inputString();
        Clazz clazz = new Clazz(name,Khoi);
        clazzManager.add(clazz);
        System.out.println("Them thanh cong");
    }

    public void showAllMenu() {
        List<Clazz> categoryList = clazzManager.getAll();
        for(Clazz c: categoryList) {
            System.out.println(c);
        }
    }
    public void showEdit(){
        System.out.println("========== Thêm Clazz ========== ");
        System.out.println("nhap id muon sua: ");
        int idEdit = Input.inputNumber();
        System.out.println("Nhập tên: ");
        String name = Input.inputString();
        System.out.println("Nhập Khoi: ");
        String Khoi = Input.inputString();
        Clazz clazz = new Clazz(idEdit,name,Khoi);
        clazzManager.update(idEdit,clazz);
        System.out.println("Sua thanh cong");
    }
    public void showMenuRemove(){
        System.out.println("===========Menu Clazz ============");
        System.out.println("Nhập Id Clazz muốn xoá: ");
        int idRemove = Input.inputNumber();
        clazzManager.delete(idRemove);
        System.out.println("Xoá thành công");
    }
}
