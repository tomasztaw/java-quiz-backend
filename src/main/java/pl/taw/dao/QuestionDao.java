package pl.taw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.taw.database.entity.QuestionEntity;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer> {

    List<QuestionEntity> findQuestionByCategory(String category);

    @Query(value = "SELECT * FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",
            nativeQuery = true)
    List<QuestionEntity> findRandomQuestionsByCategory(String category, int numQ);
}
