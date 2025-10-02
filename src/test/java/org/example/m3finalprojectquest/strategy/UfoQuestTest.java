package org.example.m3finalprojectquest.strategy;

import org.example.m3finalprojectquest.model.QuestItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UfoQuestTest {

    private UfoQuest quest;

    @BeforeEach
    void setUp() {
        quest = new UfoQuest();
        quest.initializeQuest();
    }

    @Test
    void testQuestInitialization() {
        assertNotNull(quest.getQuestItem(1), "First question should exist");
        assertNotNull(quest.getQuestItem(2), "Second question should exist");
        assertNotNull(quest.getQuestItem(3), "Third question should exist");
    }

    @Test
    void testFirstQuestionText() {
        QuestItem item = quest.getQuestItem(1);
        assertTrue(item.getQuestion().contains("втрачаєте"), "First question should mention memory loss");
    }
}