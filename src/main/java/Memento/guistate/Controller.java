package Memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Model model;
    private Gui gui;
    private List<IMemento> history;
    private List<IMemento> redoStack;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.redoStack = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        clearRedoStack();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        clearRedoStack();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    //ctrl + z
    public void undo() {
        if (!history.isEmpty()) {
            IMemento currentState = model.createMemento();
            redoStack.add(currentState);

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState((Memento) previousState);
            gui.updateGui();
        }
    }

    //ctrl + y
    public void redo() {
        if (!redoStack.isEmpty()) {
            IMemento currentState = model.createMemento();
            history.add(currentState);

            IMemento redoState = redoStack.remove(redoStack.size() - 1);
            model.restoreState((Memento) redoState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void clearRedoStack() {
        redoStack.clear();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public void showHistoryWindow() {
        HistoryWindow historyWindow = new HistoryWindow(history, this); // 传递当前 Controller
        historyWindow.show();
    }

    public void restoreState(Memento memento) {
        model.restoreState(memento);
        gui.updateGui();
    }
}
