package com.internship.shakeapp.service.impl;

import com.internship.shakeapp.dao.DrawDAO;
import com.internship.shakeapp.entity.Draw;
import com.internship.shakeapp.entity.Product;
import com.internship.shakeapp.service.DrawService;
import com.internship.shakeapp.utils.DrawUtils;
import com.internship.shakeapp.utils.ReturnMsgUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrawServiceImpl implements DrawService {

    private static final int WIN_UPPER_LIMIT = 5;
    private static final int NOT_WIN = 0;
    private static final int FIRST_PRIZE = 1;
    private static final int SECOND_PRIZE = 2;

    private final WinRecordServiceImpl winRecordService;
    private final ProductServiceImpl productService;
    private final DrawDAO drawDAO;

    public DrawServiceImpl(WinRecordServiceImpl winRecordService, DrawDAO drawDAO, ProductServiceImpl productService) {
        this.winRecordService = winRecordService;
        this.drawDAO = drawDAO;
        this.productService = productService;
    }


    /**
     * 参与抽奖模块, 当用户中奖次数达到上限或未通过风控检测时,直接返回 谢谢参与, 否则进入抽奖
     *
     * @param userId 参与抽奖的用户ID
     * @return 抽奖结果信息
     */
    @Override
    public String enterDraw(Long userId) {
        if (getWinCount(userId) >= WIN_UPPER_LIMIT || !DrawUtils.checkRisk()) {
            return ReturnMsgUtils.THX_MSG;
        }
        Long drawId = generateId(); // 生成抽奖记录ID
        int drawResult = DrawUtils.calDrawResult();

        if (drawResult > 500) { // 未中奖
            newDraw(userId, drawId, NOT_WIN);
            return ReturnMsgUtils.THX_MSG;
        }

        Product winedProduct = productService.getRandomProduct();

        if (drawResult > 100) { // 二等奖
            newDraw(userId, drawId, SECOND_PRIZE);

            winRecordService.addNewRecord(winedProduct, userId, drawId);
            return ReturnMsgUtils.SECOND_PRIZE_MSG + ": 恭喜您可以通过促销价: " + winedProduct.getPromotionPrice() +
                    " 购买 \"" + winedProduct.getProductName() + "\", 商品原价: " + winedProduct.getSalePrice(); // 获得促销价奖励
        } else { // 一等奖
            newDraw(userId, drawId, FIRST_PRIZE);

            winRecordService.addNewRecord(winedProduct, userId, drawId);
            productService.updateStockCount(winedProduct);
            return ReturnMsgUtils.FIRST_PRIZE_MSG + ": 恭喜您获得 \"" + winedProduct.getProductName() + "\"!"; // 直接获得商品
        }
    }

    /**
     * 添加抽奖记录
     *
     * @param userId       参与抽奖的用户ID
     * @param drawId       抽奖记录ID
     * @param winIndicator 中奖等级, 0为未中奖, 1为中一等奖, 2为中二等奖
     */
    @Override
    public void newDraw(Long userId, Long drawId, int winIndicator) {
        Draw draw = new Draw();
        draw.setId(drawId);
        draw.setUserId(userId);
        draw.setWin(winIndicator);
        try {
            drawDAO.newDraw(draw);
        } catch (Exception ignored) {
        }
    }

    private int getWinCount(Long userId) {
        // TODO: 放缓存
        return winRecordService.getWinRecordByUserId(userId).size();
    }

    private Long generateId() {
        // TODO: mybatis set last insert id
        List<Draw> draws = drawDAO.getAll(true);
        if (draws.size() == 0) {
            return 1L;
        }
        Draw lastDraw = draws.get(0);
        return lastDraw.getId() + 1;
    }
}
