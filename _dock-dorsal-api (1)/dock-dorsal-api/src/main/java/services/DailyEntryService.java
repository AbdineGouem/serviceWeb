package services;

import model.DailyEntry;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DailyEntryRepository;

import java.util.Date;
import java.util.List;

@Service
public class DailyEntryService {

    @Autowired
    private DailyEntryRepository dailyEntryRepository;

    public List<DailyEntry> getDailyEntriesByUser(User user) {
        return dailyEntryRepository.findByUser(user);
    }

    public DailyEntry getDailyEntryByUserAndDate(User user, Date entryDate) {
        return dailyEntryRepository.findByUserAndEntryDate(user, entryDate);
    }

    public List<DailyEntry> getDailyEntriesBetweenDates(Date startDate, Date endDate) {
        return dailyEntryRepository.findByEntryDateBetween(startDate, endDate);
    }

    public void createDailyEntry(User user, DailyEntry dailyEntry) {
        dailyEntryRepository.createDailyEntry(user, dailyEntry);
    }

    public void updateDailyEntry(DailyEntry dailyEntry) {
        dailyEntryRepository.updateDailyEntry(dailyEntry);
    }

    public void deleteDailyEntry(DailyEntry dailyEntry) {
        dailyEntryRepository.deleteDailyEntry(dailyEntry);
    }
}
