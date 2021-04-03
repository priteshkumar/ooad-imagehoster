package ImageHoster.service;

import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import java.util.List;

public interface TagService {

  Tag getTagByName(String title);

  Tag createTag(Tag tag);

  List<Image> findImageByTags(String tags);
}