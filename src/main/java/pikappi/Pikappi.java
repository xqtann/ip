package pikappi;

import pikappi.command.Command;
import pikappi.exception.PikappiException;

/**
 * Represents the main class that runs the program.
 */
public class Pikappi {
    protected static Ui ui = new Ui();
    protected static Storage storage = new Storage("data/pikappi.txt");
    protected static TaskList tasks = new TaskList();
    protected static Parser parser = new Parser(storage, tasks, ui);

    public static void main(String[] args) throws PikappiException {
//        ui.greet();
//        boolean isExit = false;
//
//
//        while (!isExit) {
//            String command = ui.readCommand();
//            ui.showLine();
//            try {
//                Command c = parser.parse(command);
//                c.execute(tasks, ui, storage);
//            } catch (PikappiException e) {
//                ui.showErrorMessage(e.getMessage());
//            }
//            isExit = parser.isExit();
//            ui.showLine();
//       }
    }

    public void loadTasks() throws PikappiException {
        tasks = storage.load();
    }


    public String getResponse(String input) {
        try {
            Command c = parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (PikappiException e) {
            return ui.showErrorMessage(e.getMessage());
        }
    }
}
