package pl.taw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.taw.dao.QuestionDao;
import pl.taw.dao.QuizDao;
import pl.taw.database.entity.QuestionEntity;
import pl.taw.database.entity.QuizEntity;
import pl.taw.dto.QuestionDto;
import pl.taw.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ResponseEntity<List<QuestionDto>> getQuizQuestions(Integer id) {
        Optional<QuizEntity> quiz = quizDao.findById(id);

        if (quiz.isPresent()) {
            List<QuestionEntity> questionsFromDb = quiz.get().getQuestions();
            List<QuestionDto> questionsForUser = new ArrayList<>();

            for (QuestionEntity qe : questionsFromDb) {
                QuestionDto qDto = QuestionDto.builder()
                        .id(qe.getId())
                        .question(qe.getQuestion())
                        .answerA(qe.getAnswerA())
                        .answerB(qe.getAnswerB())
                        .answerC(qe.getAnswerC())
                        .answerD(qe.getAnswerD())
                        .build();
                questionsForUser.add(qDto);
            }

            return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        QuizEntity quiz = quizDao.findById(id).orElseThrow();
        List<QuestionEntity> questions = quiz.getQuestions();
        if (responses.size() != questions.size()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        int rightAnswer = 0;
        int index = 0;
        for (Response respons : responses) {
            if (respons.getResponseAnswer().equals(questions.get(index).getCorrectAnswer())) {
                rightAnswer++;
            }
            index++;
        }
        return new ResponseEntity<>(rightAnswer, HttpStatus.OK);
    }
}
