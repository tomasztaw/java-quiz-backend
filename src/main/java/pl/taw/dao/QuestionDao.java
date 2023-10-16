package pl.taw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.taw.database.entity.QuestionEntity;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionEntity, Integer> {

    List<QuestionEntity> findQuestionByCategory(String category);

}
