package org.example.m3finalprojectquest.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.example.m3finalprojectquest.model.QuestItem;

import java.io.IOException;

public interface Quest {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    QuestItem getQuestItem(int questionNumber);

    String processUserAnswer(QuestItem item, String userAnswer);

    void initializeQuest();


}
