package pl.taw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.taw.dao.QuestionDao;
import pl.taw.database.entity.QuestionEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<QuestionEntity>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
    }

    public List<String> getAllCategories() {
        return questionDao.findAll().stream()
                .map(QuestionEntity::getCategory)
                .distinct()
                .toList();
    }

    public List<QuestionEntity> getQuestionsByCategoryMyMethod(String category) {
        return questionDao.findAll().stream()
                .filter(question -> category.equalsIgnoreCase(question.getCategory()))
                .toList();
    }


    public ResponseEntity<List<QuestionEntity>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findQuestionByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> addQuestion(QuestionEntity questionEntity) {
        try {
            questionDao.save(questionEntity);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
        }
    }

    public String delete(Integer id) {
        questionDao.deleteById(id);
        return "Question with %s was deleted".formatted(id);
    }
}
