package personal.model;

import java.util.List;

public interface Repository {
    List<Toy> getAllToy();
    String CreateToy(Toy toy);


    String DeleteToy(String id);

    String UpdateToy(String id, String note, String text, String data);
    String WinningToy(String id);
}
