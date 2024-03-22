package controller;

import model.DailyEntry;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.DailyEntryService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/daily-entries")
public class DailyEntryController {

    @Autowired
    private DailyEntryService dailyEntryService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<DailyEntry>> getDailyEntriesByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        List<DailyEntry> entries = dailyEntryService.getDailyEntriesByUser(user);
        return new ResponseEntity<>(entries, HttpStatus.OK);
    }

    @GetMapping("/{userId}/{entryDate}")
    public ResponseEntity<DailyEntry> getDailyEntryByUserAndDate(@PathVariable Long userId,
                                                                 @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date entryDate) {
        User user = new User();
        user.setId(userId);
        DailyEntry entry = dailyEntryService.getDailyEntryByUserAndDate(user, entryDate);
        return new ResponseEntity<>(entry, HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> createDailyEntry(@PathVariable Long userId, @RequestBody DailyEntry dailyEntry) {
        User user = new User();
        user.setId(userId);
        dailyEntryService.createDailyEntry(user, dailyEntry);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateDailyEntry(@RequestBody DailyEntry dailyEntry) {
        dailyEntryService.updateDailyEntry(dailyEntry);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{entryId}")
    public ResponseEntity<?> deleteDailyEntry(@PathVariable Long entryId) {
        // You may want to add more validation or security checks here
        DailyEntry entry = new DailyEntry();
        entry.setId(entryId);
        dailyEntryService.deleteDailyEntry(entry);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
