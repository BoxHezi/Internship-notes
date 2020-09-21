package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.service.DrawService;
import org.springframework.stereotype.Component;

@Component
public class DrawServiceImpl implements DrawService {

    private static final int WIN_UPPER_LIMIT = 5;

    private final WinRecordServiceImpl winRecordService;

    public DrawServiceImpl(WinRecordServiceImpl winRecordService) {
        this.winRecordService = winRecordService;
    }

    @Override
    public String enterDraw(Long userId) {
        if (getWinCount(userId) >= WIN_UPPER_LIMIT) {
            return "谢谢参与";
        } else {
            // TODO: 抽奖算法
            return "开始抽奖";
        }
    }

    private int getWinCount(Long userId) {
        return winRecordService.getWinRecordByUserId(userId).size();
    }
}
