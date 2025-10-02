package org.example.m3finalprojectquest.strategy;

import org.example.m3finalprojectquest.model.QuestItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseQuestTest {

    private BaseQuest quest;

    @BeforeEach
    void setUp() {
        quest = new UfoQuest();
        quest.initializeQuest();
    }

    @Test
    void testPositiveAnswer() {
        QuestItem item = quest.getQuestItem(1);

        String result = quest.processUserAnswer(item, "Tak");
        assertNull(result, "First step should not return immediate result");
    }

    @Test
    void testNegativeAnswer() {
        QuestItem item = quest.getQuestItem(1);

        String result = quest.processUserAnswer(item, "Hi");
        assertEquals("Програш", result, "Answer 'No' should lead to negative result");
    }

    @Test
    void testFinalPositiveAnswer() {
        QuestItem item = quest.getQuestItem(3);

        String result = quest.processUserAnswer(item, "Tak");
        assertEquals("Виграш", result, "Final 'Yes' should lead to victory");
    }

    @Test
    void testFinalNegativeAnswer() {
        QuestItem item = quest.getQuestItem(3);

        String result = quest.processUserAnswer(item, "Hi");
        assertEquals("Програш", result, "Final 'No' should lead to defeat");
    }
}
