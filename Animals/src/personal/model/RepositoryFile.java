package personal.model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository {
    private ToyMapper mapper = new ToyMapper();
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Toy> getAllToy() {
        List<String> lines = fileOperation.readAllLines();
        List<Toy> toys = new ArrayList<>();
        for (String line : lines) {
            toys.add(mapper.map(line));
        }
        return toys;
    }

    @Override
    public String CreateToy(Toy toy) {

        List<Toy> toys = getAllToy();
        int max = 0;
        for (Toy item : toys) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        toy.setId(id);
        toys.add(toy);
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    public String DeleteToy(String id) {

        List<Toy> toys = getAllToy();
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            if (item.getId().equals(id))
                continue;
            else {
                lines.add(mapper.map(item));
            }
        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    @Override
    public String UpdateToy(String id, String toy, String drop, String quan) {

        List<Toy> toys = getAllToy();
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            if (item.getId().equals(id)){
                item.setToy(toy);
                item.setDrop(drop);
                item.setQuantity(quan);
                lines.add(mapper.map(item));
            } else {
                lines.add(mapper.map(item));
            }

        }
        fileOperation.saveAllLines(lines);
        return id;
    }

    @Override
    public String WinningToy(String id) {
        List<Toy> toys = getAllToy();
        List<String> lines = new ArrayList<>();
        for (Toy item: toys) {
            if (item.getId().equals(id)) {
                int quan = Integer.parseInt(item.getQuantity());
                if (quan > 1) {
                    quan--;
                    String quantity = String.format("%d", quan);
                    item.setQuantity(quantity);
                    lines.add(mapper.map(item));
                } else if (quan == 1) {
                    DeleteToy(item.getId());
                }
            } else {
                lines.add(mapper.map(item));
            }
        }
        fileOperation.saveAllLines(lines);
        return id;
    }
}
