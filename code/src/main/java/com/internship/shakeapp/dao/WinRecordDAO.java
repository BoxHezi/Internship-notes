package com.internship.shakeapp.dao;

import com.internship.shakeapp.entity.WinRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WinRecordDAO {

    List<WinRecord> getAllRecord(Boolean descOrder);

    List<WinRecord> getWinRecordByUserId(Long userId);

    void insertNewRecord(WinRecord winRecord);

}
