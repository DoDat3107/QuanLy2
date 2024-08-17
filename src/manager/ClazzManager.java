package manager;

import model.Clazz;
import model.Student;
import saveData.ReadAndWriteClazz;
import saveData.ReadAndWriteStudent;

import java.util.Collections;
import java.util.List;

public class ClazzManager implements IManager<Clazz> {
    private List<Clazz> list;
    private ReadAndWriteClazz readAndWriteClazz = new ReadAndWriteClazz();
    public ClazzManager() {
        this.list = readAndWriteClazz.readData();
    }

    @Override
    public void add(Clazz clazz) {
        this.list.add(clazz);
        readAndWriteClazz.writeData(list);
    }

    @Override
    public void delete(int id) {
        int index = this.findById(id);
        this.list.remove(index);
    }

    @Override
    public void update(int id, Clazz clazz) {
        int index = this.findById(id);
        this.list.set(index, clazz);
        readAndWriteClazz.writeData(this.list);
    }

    @Override
    public List<Clazz> getAll() {
        return this.list;
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
}
