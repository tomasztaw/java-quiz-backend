package pl.taw.dto;

import jakarta.persistence.Column;
import lombok.*;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Integer id;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
}
