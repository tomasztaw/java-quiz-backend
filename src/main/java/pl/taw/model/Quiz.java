package pl.taw.model;

import pl.taw.database.entity.QuestionEntity;

import java.util.List;

public class Quiz {

    private Integer id;
    private String title;
    private List<QuestionEntity> questions;
}
