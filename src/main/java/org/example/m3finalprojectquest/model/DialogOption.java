package org.example.m3finalprojectquest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DialogOption {
    private String optionText;
    private int nextQuestion;
}
