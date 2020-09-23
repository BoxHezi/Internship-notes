package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.entity.WinRecord;

import java.util.List;

public interface WinRecordService {

    List<WinRecord> getWinRecordByUserId(Long userId);

    void addNewRecord(Product product, Long userId, Long drawId);

}
