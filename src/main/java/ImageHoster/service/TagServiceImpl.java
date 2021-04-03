package ImageHoster.service;

import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.repository.TagRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TagServiceImpl implements TagService {

  @Autowired
  private TagRepository tagRepository;

  @Override
  public Tag getTagByName(String title) {
    return tagRepository.findTag(title);
  }

  @Override
  public Tag createTag(Tag tag) {
    return tagRepository.createTag(tag);
  }

  @Override
  public List<Image> findImageByTags(String tags) {
    return tagRepository.findImageByTag(tags);
  }
}
