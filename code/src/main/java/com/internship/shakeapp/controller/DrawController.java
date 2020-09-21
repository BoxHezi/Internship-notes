package com.internship.shakeapp.controller;

import com.internship.shakeapp.service.impl.DrawServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("user/draw")
public class DrawController {

    private final DrawServiceImpl drawService;

    public DrawController(DrawServiceImpl drawService) {
        this.drawService = drawService;
    }

    @RequestMapping(method = {
            RequestMethod.POST,
            RequestMethod.GET
    })
    public String enterDraw(Long userId) {
        if (userId == null) {
            return "抽奖失败 - userId为空";
        }
        return drawService.enterDraw(userId);
    }
}
