package com.internship.shakeapp.dao;

import com.internship.shakeapp.entity.Draw;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DrawDAO {

    List<Draw> getAll(Boolean descOrder);

    void newDraw(Draw draw);

}
