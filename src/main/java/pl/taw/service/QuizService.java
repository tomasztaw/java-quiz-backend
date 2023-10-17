package pl.taw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.taw.dao.QuestionDao;
import pl.taw.dao.QuizDao;
import pl.taw.database.entity.QuestionEntity;
import pl.taw.database.entity.QuizEntity;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;
    @Autowired
    private QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<QuestionEntity> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        QuizEntity quiz = QuizEntity.builder()
                .title(title)
                .questions(questions)
                .build();
        quizDao.save(quiz);

        return new ResponseEntity<>("success created quiz", HttpStatus.CREATED);
    }
}
