package repository.action;

import database.DBConnectionFactory;
import model.Action;
import model.builder.ActionBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ActionRepositoryMySQLTest {


    private static ActionRepository actionRepository;

    @Before
    public void setUp() throws Exception {

        actionRepository = new ActionRepositoryMySQL(new DBConnectionFactory().getConnectionWrapper(true).getConnection());

        actionRepository.save(new ActionBuilder()
                                .setId((long) 1)
                                .setDate(new Date(System.currentTimeMillis()))
                                .setDetails("Added a new client")
                                .setEmployeeId((long) 3)
                                .build());
    }

    @Test
    public void save() {

        actionRepository.save(new ActionBuilder()
                .setId((long) 2)
                .setDate(new Date(System.currentTimeMillis()))
                .setDetails("Processed bill payment")
                .setEmployeeId((long) 4)
                .build());

    }

    @Test
    public void getActionsByEmployeeId() {

        Action action = new ActionBuilder()
                .setId((long) 5)
                .setDate(new Date(System.currentTimeMillis()))
                .setDetails("Processed bill payment")
                .setEmployeeId((long) 6)
                .build();

        actionRepository.save(action);

        List<Action> actions = actionRepository.getActionsByEmployeeId((long) 6);

        assertEquals(actions.size(), 1);
    }
}