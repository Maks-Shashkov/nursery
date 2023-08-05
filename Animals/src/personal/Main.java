package personal;

import personal.controllers.ToyController;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.Repository;
import personal.model.RepositoryFile;
import personal.views.ViewNote;

public class Main {
    public static void main(String[] args) throws Exception {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryFile(fileOperation);
        ToyController controller = new ToyController(repository);
        ViewNote view = new ViewNote(controller);
        view.run();
    }
}
