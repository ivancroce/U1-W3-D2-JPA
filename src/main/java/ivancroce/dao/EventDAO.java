package ivancroce.dao;

import ivancroce.entities.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventDAO {

    // em is our "contact" with the DB
    private EntityManager em;

    public EventDAO(EntityManager em) {
        this.em = em;
    }

    // save method (create)
    public void save(Event newEvent) {

        // 1. we ask the em to create a new transaction.
        EntityTransaction transaction = em.getTransaction();

        // 2. begin transaction.
        transaction.begin();

        // 3. add newEvent to the Persistence Context with persist (at this stage newEvent is still not saved in table in the DB)
        em.persist(newEvent);

        // 4. commit = write data in the DB
        transaction.commit();
        System.out.println("The event '" + newEvent.getTitle() + "' has been successfully saved in the DB.");
    }
}
