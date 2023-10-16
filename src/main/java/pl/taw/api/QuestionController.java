package pl.taw.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.taw.database.entity.QuestionEntity;
import pl.taw.service.QuestionService;
import pl.taw.utiles.QuestionCategory;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<QuestionEntity> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return questionService.getAllCategories();
    }

    @GetMapping("/category/{category}/my")
    public List<QuestionEntity> getAllQuestionsByCategoryMyMethod(@PathVariable("category") String category) {
        return questionService.getQuestionsByCategoryMyMethod(category);
    }

    @GetMapping("/category/{category}")
    public List<QuestionEntity> getAllQuestionsByCategory(@PathVariable("category") String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody QuestionEntity questionEntity) {
        return questionService.addQuestion(questionEntity);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        return questionService.delete(id);
    }
}
