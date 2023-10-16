package pl.taw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.taw.dao.QuestionDao;
import pl.taw.database.entity.QuestionEntity;
import pl.taw.utiles.QuestionCategory;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public List<QuestionEntity> getAllQuestions() {
        return questionDao.findAll();
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


    public List<QuestionEntity> getQuestionsByCategory(String category) {
        return questionDao.findQuestionByCategory(category);
    }

    public String addQuestion(QuestionEntity questionEntity) {
        questionDao.save(questionEntity);
        return "success";
    }

    public String delete(Integer id) {
        questionDao.deleteById(id);
        return "Question with %s was deleted".formatted(id);
    }
}
