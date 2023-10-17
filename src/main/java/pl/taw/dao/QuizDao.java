package pl.taw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.taw.database.entity.QuizEntity;

public interface QuizDao extends JpaRepository<QuizEntity, Integer> {
}
