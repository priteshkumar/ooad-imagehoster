package ImageHoster.service;

import ImageHoster.model.Tag;

public interface TagService {

	Tag getTagByName(String title);

	Tag createTag(Tag tag);

}