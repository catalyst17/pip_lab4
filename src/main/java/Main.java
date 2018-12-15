import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory sf = Persistence.createEntityManagerFactory("myUnit");
        EntityManager entityManager = sf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new UserEntity("catalust15", "qwerty"));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
