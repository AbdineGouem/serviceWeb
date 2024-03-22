package repository;

import model.DailyEntry;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class DailyEntryRepositoryImpl implements DailyEntryRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<DailyEntry> findByUser(User user) {
        return entityManager.createQuery("SELECT d FROM DailyEntry d WHERE d.user = :user", DailyEntry.class)
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    public DailyEntry findByUserAndEntryDate(User user, Date entryDate) {
        return entityManager.createQuery("SELECT d FROM DailyEntry d WHERE d.user = :user AND d.entryDate = :entryDate", DailyEntry.class)
                .setParameter("user", user)
                .setParameter("entryDate", entryDate)
                .getSingleResult();
    }

    @Override
    public List<DailyEntry> findByEntryDateBetween(Date startDate, Date endDate) {
        return entityManager.createQuery("SELECT d FROM DailyEntry d WHERE d.entryDate BETWEEN :startDate AND :endDate", DailyEntry.class)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    @Override
    public void createDailyEntry(User user, DailyEntry dailyEntry) {
        dailyEntry.setUser(user);
        entityManager.persist(dailyEntry);
    }

    @Override
    public void updateDailyEntry(DailyEntry dailyEntry) {
        entityManager.merge(dailyEntry);
    }

    @Override
    public void deleteDailyEntry(DailyEntry dailyEntry) {
        entityManager.remove(entityManager.contains(dailyEntry) ? dailyEntry : entityManager.merge(dailyEntry));
    }
}
