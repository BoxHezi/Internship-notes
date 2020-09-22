package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.DrawDAO;
import com.internship.shakeapp.entity.Draw;
import com.internship.shakeapp.service.DrawService;
import com.internship.shakeapp.utils.DrawUtils;
import com.internship.shakeapp.utils.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrawServiceImpl implements DrawService {

    private static final int WIN_UPPER_LIMIT = 5;
    private static final int NOT_WIN = 0;
    private static final int FIRST_PRIZE = 1;
    private static final int SECOND_PRIZE = 2;

    private final WinRecordServiceImpl winRecordService;
    private final DrawDAO drawDAO;

    public DrawServiceImpl(WinRecordServiceImpl winRecordService, DrawDAO drawDAO) {
        this.winRecordService = winRecordService;
        this.drawDAO = drawDAO;
    }

    @Override
    public String enterDraw(Long userId) {
        if (getWinCount(userId) >= WIN_UPPER_LIMIT || !DrawUtils.riskCheck()) {
            return StringUtils.THX_MSG;
        } else {
            int drawResult = DrawUtils.startDraw();
            if (drawResult > 500) {
                newDraw(userId, NOT_WIN);
                return StringUtils.THX_MSG;
            } else if (drawResult > 100 ) {
                newDraw(userId, SECOND_PRIZE);
                // TODO: 获得商品促销价购买权限
                return StringUtils.SECOND_PRIZE_MSG; // 获得促销价奖励
            } else {
                newDraw(userId, FIRST_PRIZE);
                // TODO: 检查实际库存
                return StringUtils.FIRST_PRIZE_MSG; // 直接获得商品
            }
        }
    }

    /**
     * 添加抽奖记录
     * @param userId 参与抽奖的用户ID
     * @param winIndicator 中奖等级, 0为未中奖, 1为中一等奖, 2为中二等奖
     */
    @Override
    public void newDraw(Long userId, int winIndicator) {
        Draw draw = new Draw();
        draw.setId(generateId());
        draw.setUserId(userId);
        draw.setWin(winIndicator);
        try {
            drawDAO.newDraw(draw);
        } catch (Exception ignored) {
        }
    }

    private int getWinCount(Long userId) {
        return winRecordService.getWinRecordByUserId(userId).size();
    }

    private Long generateId() {
        List<Draw> draws = drawDAO.getAll(true);
        if (draws.size() == 0) {
            return 1L;
        }
        Draw lastDraw = draws.get(0);
        return lastDraw.getId() + 1;
    }
}
