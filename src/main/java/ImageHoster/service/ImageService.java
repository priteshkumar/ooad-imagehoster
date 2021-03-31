package ImageHoster.service;

import java.util.List;

import ImageHoster.model.Image;

public interface ImageService {

	//Call the getAllImages() method in the Repository and obtain a List of all the images in the database
	List<Image> getAllImages();

	//The method calls the createImage() method in the Repository and passes the image to be persisted in the database
	void uploadImage(Image image);

	//The method calls the getImageByTitle() method in the Repository and passes the title of the image to be fetched
	Image getImageByIdAndTitle(Integer id, String title);

	//The method calls the getImage() method in the Repository and passes the id of the image to be fetched
	Image getImage(Integer imageId);

	//The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
	void updateImage(Image updatedImage);

	//The method calls the deleteImage() method in the Repository and passes the Image id of the image to be deleted in the database
	void deleteImage(Integer imageId);

}