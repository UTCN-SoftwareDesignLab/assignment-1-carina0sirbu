package repository.action;

import model.Action;

import java.util.List;

public interface ActionRepository {

    boolean save(Action action);

    List<Action> getActionsByEmployeeId(Long id);
}
