package com.internship.shakeapp.service;

import com.internship.shakeapp.entity.WinRecord;

import java.util.List;

public interface WinRecordService {

    List<WinRecord> getWinRecordByUserId(Long userId);

}
