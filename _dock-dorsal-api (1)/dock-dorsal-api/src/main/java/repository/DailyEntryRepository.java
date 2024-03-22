package repository;

import model.DailyEntry;
import model.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DailyEntryRepository {
    List<DailyEntry> findByUser(User user);
    DailyEntry findByUserAndEntryDate(User user, Date entryDate);
    List<DailyEntry> findByEntryDateBetween(Date startDate, Date endDate);
    void createDailyEntry(User user, DailyEntry dailyEntry);
    void updateDailyEntry(DailyEntry dailyEntry);
    void deleteDailyEntry(DailyEntry dailyEntry);
}