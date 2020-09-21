package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.WinRecordDAO;
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
}
