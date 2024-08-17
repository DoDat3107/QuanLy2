package model;

public class Clazz {
    private int id;
    private String name;
    private String Khoi;
    private static int nextId = 1;

    public Clazz(String name, String Khoi) {
        this.id = nextId++;
        this.name = name;
        this.Khoi = Khoi;
    }

    public Clazz(int id, String name, String Khoi) {
        this.id = id;
        this.name = name;
        this.Khoi = Khoi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKhoi() {
        return Khoi;
    }

    public void setKhoi(String khoi) {
        Khoi = khoi;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Clazz.nextId = nextId;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Khoi='" + Khoi + '\'' +
                '}';
    }
}
