package ImageHoster.repository;

import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class TagRepositoryImpl implements TagRepository {

  @PersistenceUnit(unitName = "imageHoster")
  private EntityManagerFactory emf;

  @Override
  public Tag createTag(Tag tag) {
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
      transaction.begin();
      em.persist(tag);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
    }
    return tag;
  }

  @Override
  public Tag findTag(String tagName) {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<Tag> typedQuery = em
          .createQuery("SELECT t from Tag t where t.name =:tagName", Tag.class)
          .setParameter("tagName", tagName);
      return typedQuery.getSingleResult();
    } catch (NoResultException nre) {
      return null;
    }
  }

  @Override
  public List<Image> findImageByTag(String tag) {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<Tag> typedQuery = em
          .createQuery("SELECT t from Tag t where t.name =:tagName", Tag.class)
          .setParameter("tagName", tag);
      return typedQuery.getSingleResult().getImages();
    } catch (NoResultException nre) {
      return null;
    }
  }

  @Override
  public List<Tag> getAllTags() {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<Tag> typedQuery = em
          .createQuery("SELECT t from Tag t", Tag.class);
      return typedQuery.getResultList();
    } catch (NoResultException nre) {
      return null;
    }
  }
}
