package Memento.guistate;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class HistoryWindow {
    private Stage historyStage;
    private List<IMemento> stateHistory;
    private Controller controller;

    public HistoryWindow(List<IMemento> stateHistory, Controller controller) {
        this.stateHistory = stateHistory;
        this.controller = controller;
        this.historyStage = new Stage();
    }

    public void show() {
        ListView<String> listView = new ListView<>();

        // add metadata of each Memento to the ListView
        for (IMemento memento : stateHistory) {
            Memento concreteMemento = (Memento) memento;
            listView.getItems().add(concreteMemento.getMetadata());
        }

        // restore the state of the selected Memento
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                Memento selectedState = (Memento) stateHistory.get(selectedIndex);
                controller.restoreState(selectedState);
            }
        });

        VBox layout = new VBox(listView);
        Scene scene = new Scene(layout, 500, 400);
        historyStage.setScene(scene);
        historyStage.setTitle("History");
        historyStage.show();
    }
}
