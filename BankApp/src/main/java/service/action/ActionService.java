package service.action;

import model.Action;

import java.util.List;

public interface ActionService {

    boolean save(Action action);

    List<Action> getActionsByEmployeeId(Long id);
}
