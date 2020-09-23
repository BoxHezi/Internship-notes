package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.WinRecordDAO;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.entity.WinRecord;
import com.internship.shakeapp.service.WinRecordService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WinRecordServiceImpl implements WinRecordService {

    private final WinRecordDAO winRecordDAO;

    public WinRecordServiceImpl(WinRecordDAO winRecordDAO) {
        this.winRecordDAO = winRecordDAO;
    }

    @Override
    public List<WinRecord> getWinRecordByUserId(Long userId) {
        return winRecordDAO.getWinRecordByUserId(userId);
    }

    @Override
    public void addNewRecord(Product product, Long userId, Long drawId) {
        WinRecord newRecord = new WinRecord(product.getId(), product.getCompanyId(), userId, drawId);
        newRecord.setId(generateId());
        try {
            winRecordDAO.insertNewRecord(newRecord);
        } catch (Exception ignored) {
        }
    }

    private Long generateId() {
        List<WinRecord> winRecords = winRecordDAO.getAllRecord(true);
        if (winRecords.size() == 0) {
            return 1L;
        }
        WinRecord lastRecord = winRecords.get(0);
        return lastRecord.getId() + 1;
    }
}
