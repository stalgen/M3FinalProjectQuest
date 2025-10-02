package org.example.m3finalprojectquest.strategy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.m3finalprojectquest.constants.AnswerOptions;
import org.example.m3finalprojectquest.constants.PagePaths;
import org.example.m3finalprojectquest.model.DialogOption;
import org.example.m3finalprojectquest.model.QuestItem;

import java.io.IOException;
import java.util.Arrays;

public class UfoQuest extends BaseQuest{

    @Override
    public void initializeQuest() {
        DialogOption dialogOption1_1 = new DialogOption(AnswerOptions.YES, 2);
        DialogOption dialogOption1_2 = new DialogOption(AnswerOptions.NO, -1);
        QuestItem item1 = new QuestItem("Ви втрачаєте память. Прийняти виклик НЛО?", Arrays.asList(dialogOption1_1, dialogOption1_2),null, "Програш");

        DialogOption dialogOption2_1 = new DialogOption(AnswerOptions.YES, 3);
        DialogOption dialogOption2_2 = new DialogOption(AnswerOptions.NO, -1);
        QuestItem item2 = new QuestItem("Ви прийняли виклик. Піднятися на капітанський місток?", Arrays.asList(dialogOption2_1, dialogOption2_2),null, "Програш");

        DialogOption dialogOption3_1 = new DialogOption(AnswerOptions.YES, -1);
        DialogOption dialogOption3_2 = new DialogOption(AnswerOptions.NO, -1);
        QuestItem item3 = new QuestItem("Ви піднялись на місток. Хто ви? Розкажете правду?", Arrays.asList(dialogOption3_1, dialogOption3_2),"Виграш", "Програш");

        questMap.put(1, item1);
        questMap.put(2, item2);
        questMap.put(3, item3);
    }

    @Override
    protected void handleUserAnswer(HttpServletRequest request, HttpServletResponse response,
                                    HttpSession session, int currentQuestion, String userAnswer, QuestItem item)
        throws ServletException, IOException {
        String result = processUserAnswer(item, userAnswer);

        if (result != null) {
            logger.info("Quest result: {}", result);
            session.setAttribute("result", result);
            request.getRequestDispatcher(PagePaths.RESULT_PAGE).forward(request, response);
        } else {
            for (DialogOption option : item.getDialogOptions()) {
                if (option.getOptionText().equalsIgnoreCase(userAnswer.trim())) {
                    currentQuestion = option.getNextQuestion();
                    break;
                }
            }
            session.setAttribute("currentQuestion", currentQuestion);
            QuestItem nextItem = getQuestItem(currentQuestion);
            logger.info("Moving to next question: {}", currentQuestion);
            request.setAttribute("questItem", nextItem);
            request.getRequestDispatcher(PagePaths.QUEST_PAGE).forward(request, response);
        }
    }

    @Override
    public QuestItem getQuestItem(int questionNumber) {
        return questMap.get(questionNumber);
    }
}
