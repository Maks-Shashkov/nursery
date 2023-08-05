package personal.views;

import personal.controllers.ToyController;
import personal.model.Toy;

import java.util.List;
import java.util.Scanner;

public class ViewNote {

    private ToyController toyController;

    public ViewNote(ToyController toyController) {
        this.toyController = toyController;
    }

    public void run() throws Exception {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String toy = prompt("Название игрушки: ");
                    String text = prompt("Шанс выйгрыша: ");
                    String quan = prompt("Количество: ");
                    toyController.saveToy(new Toy(toy, text, quan));
                    break;
                case READ:
                    String id = prompt("Id игрушки: ");
                    try {
                        Toy toyInput = toyController.readToy(id);
                        System.out.println(toyInput);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    String idUser = prompt("Id игрушки: ");
                    try {
                        toyController.deleteToy(idUser);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    List<Toy> toys = toyController.readAllToy();
                    for (Toy listToy : toys) {
                        System.out.println(listToy);
                    }
                    break;
                case UPDATE:
                    String upId = prompt("Id:");
                    String upToy = prompt("Название: ");
                    String upDrop = prompt("Шанс выйгрыша: ");
                    String upQuan = prompt("Количество: ");
                    toyController.UpdateToy(upId,upToy,upDrop,upQuan);
                    break;
                case WIN:
                    String Id = prompt("Id: ");
                    toyController.WinningToy(Id);
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
