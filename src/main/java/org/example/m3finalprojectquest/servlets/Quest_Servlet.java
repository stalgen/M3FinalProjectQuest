package org.example.m3finalprojectquest.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.m3finalprojectquest.constants.PagePaths;
import org.example.m3finalprojectquest.constants.QuestTypes;
import org.example.m3finalprojectquest.model.QuestItem;
import org.example.m3finalprojectquest.strategy.Quest;
import org.example.m3finalprojectquest.strategy.UfoQuest;

import java.io.IOException;

@WebServlet(name = "questServlet", value = "/quest-servlet")
public class Quest_Servlet extends HttpServlet {
    private static final int FIRST_QUESTION = 1;
    private static final String QUEST_PAGE = "/quest.jsp";
    private Quest quest;

    public void setQuestStrategy(Quest quest) {
        this.quest = quest;
    }

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("currentQuestion", FIRST_QUESTION);
        session.setAttribute("result", null);

        String questType = request.getParameter("type");

        if (QuestTypes.UFO.equals(questType)) {
            setQuestStrategy(new UfoQuest());
        }

        quest.initializeQuest();

        QuestItem item = quest.getQuestItem(1);
        request.setAttribute("questItem", item);
        request.getRequestDispatcher(PagePaths.QUEST_PAGE).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quest.execute(request, response);
    }

    public  void destroy() {
    }
}
