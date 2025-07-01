package ivancroce;

import ivancroce.dao.EventDAO;
import ivancroce.entities.Event;
import ivancroce.entities.EventType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("events_management_pu");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager(); // em manages all the operations with the DB
        EventDAO ed = new EventDAO(em); // instance of our DAO, passing em

        // creating a new event
        Event birthday = new Event("Aldo Baglio's b-day", LocalDate.of(2025, 07, 01), "Big Party!", EventType.PRIVATE, 30);

        ed.save(birthday);

        em.close();
        emf.close();
    }
}
