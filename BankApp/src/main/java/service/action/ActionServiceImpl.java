package service.action;

import model.Action;

import repository.action.ActionRepository;

import java.util.List;

public class ActionServiceImpl implements ActionService {

    private final ActionRepository repository;

    public ActionServiceImpl(ActionRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(Action action) {
        return repository.save(action);
    }

    @Override
    public List<Action> getActionsByEmployeeId(Long id) {
        return repository.getActionsByEmployeeId(id);
    }
}
