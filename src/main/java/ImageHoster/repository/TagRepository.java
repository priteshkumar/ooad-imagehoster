package ImageHoster.repository;

import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import java.util.List;

public interface TagRepository {

	Tag createTag(Tag tag);

	Tag findTag(String tagName);

	List<Image> findImageByTag(String tag);

}