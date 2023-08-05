package personal.controllers;

import personal.model.Toy;
import personal.model.Repository;

import java.util.List;

public class ToyController {
    private final Repository repository;

    public ToyController(Repository repository) {
        this.repository = repository;
    }

    public void saveToy(Toy toy) {
        repository.CreateToy(toy);
    }

    public void deleteToy(String id) {
        repository.DeleteToy(id);
    }

    public Toy readToy(String userId) throws Exception {
        List<Toy> toys = repository.getAllToy();
        for (Toy toy : toys) {
            if (toy.getId().equals(userId)) {
                return toy;
            }
        }

        throw new Exception("User not found");
    }
    public List<Toy> readAllToy() throws Exception {
        List<Toy> toys = repository.getAllToy();
        return toys;
    }

    public void UpdateToy(String id, String note, String text, String data) {
        repository.UpdateToy(id ,note, text, data);
    }

    public void WinningToy(String Id) {
        repository.WinningToy(Id);
    }

}
