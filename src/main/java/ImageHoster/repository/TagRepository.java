package ImageHoster.repository;

import ImageHoster.model.Tag;

public interface TagRepository {

	Tag createTag(Tag tag);

	Tag findTag(String tagName);

}