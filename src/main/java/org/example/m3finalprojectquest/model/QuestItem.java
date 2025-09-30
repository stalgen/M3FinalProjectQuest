package org.example.m3finalprojectquest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class QuestItem {
    private String question;
    private List<DialogOption> dialogOptions;
    private String positivResult;
    private String negativeResult;
}
