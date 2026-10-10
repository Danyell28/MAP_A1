package org.example;

import org.Controller.*;
import org.Repository.*;
import org.View.UI;

public class Main {
    static void main() {
        IRepository repo = new Repository(10);
        repo.generateData();

        Controller controller = new Controller(repo);
        UI view = new UI(controller);
        view.menu();
    }
}
