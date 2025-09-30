package org.example.m3finalprojectquest.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.m3finalprojectquest.constants.AnswerOptions;
import org.example.m3finalprojectquest.model.DialogOption;
import org.example.m3finalprojectquest.model.QuestItem;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseQuest implements Quest {
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseQuest.class);

    protected Map<Integer, QuestItem> questMap = new HashMap<>();

    protected abstract void handleUserAnswer(HttpServletRequest request, HttpServletResponse response,
                                             HttpSession session, int currentQuestion, String userAnswer, QuestItem item)
            throws ServletException, IOException;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
       HttpSession session = request.getSession();
       int currentQuestion = (int) session.getAttribute("currentQuestion");
       QuestItem item = getQuestItem(currentQuestion);
       String userAnswer = request.getParameter("userAnswer");

       handleUserAnswer(request, response, session, currentQuestion, userAnswer, item);
    }

    @Override
    public String processUserAnswer(QuestItem item, String userAnswer) {
        for (DialogOption option : item.getDialogOptions()) {
            if (option.getOptionText().equalsIgnoreCase(userAnswer)) {
                if (AnswerOptions.YES.equalsIgnoreCase(userAnswer)) {
                    return item.getPositivResult();
                } else if (AnswerOptions.NO.equalsIgnoreCase(userAnswer)) {
                    return item.getNegativeResult();
                }
            }
        }
        return  null;
    }
}
