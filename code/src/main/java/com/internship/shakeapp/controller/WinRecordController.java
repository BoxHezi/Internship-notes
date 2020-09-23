package com.internship.shakeapp.controller;

import com.internship.shakeapp.dao.WinRecordDAO;
import com.internship.shakeapp.entity.WinRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("winRecord")
public class WinRecordController {

    private final WinRecordDAO winRecordDAO;

    public WinRecordController(WinRecordDAO winRecordDAO) {
        this.winRecordDAO = winRecordDAO;
    }

    @GetMapping()
    public List<WinRecord> getAllRecord() {
        return winRecordDAO.getLastFifty();
    }

    @GetMapping(value = "{userId}")
    public List<WinRecord> findWinRecordForUser(@PathVariable Long userId) {
        return winRecordDAO.getWinRecordByUserId(userId);
    }

}
