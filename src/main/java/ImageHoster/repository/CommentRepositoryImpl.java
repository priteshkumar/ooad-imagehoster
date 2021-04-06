package ImageHoster.repository;

import ImageHoster.model.Comment;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

  @PersistenceUnit(unitName = "imageHoster")
  private EntityManagerFactory emf;

  @Override
public void addComment(Comment comment) {
    EntityManager entityManager = emf.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();
    entityManager.persist(comment);
    entityTransaction.commit();
  }
}
