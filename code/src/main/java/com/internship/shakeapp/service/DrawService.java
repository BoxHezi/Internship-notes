package com.internship.shakeapp.service;

public interface DrawService {

    String enterDraw(Long userId);

    void newDraw(Long userId, Long drawId, int winIndicator);
}
