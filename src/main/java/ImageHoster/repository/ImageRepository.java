package ImageHoster.repository;

import java.util.List;

import ImageHoster.model.Image;

public interface ImageRepository {

	//The method receives the Image object to be persisted in the database
	//Creates an instance of EntityManager
	//Starts a transaction
	//The transaction is committed if it is successful
	//The transaction is rolled back in case of unsuccessful transaction
	Image uploadImage(Image newImage);

	//The method creates an instance of EntityManager
	//Executes JPQL query to fetch all the images from the database
	//Returns the list of all the images fetched from the database
	List<Image> getAllImages();

	//The method creates an instance of EntityManager
	//Executes JPQL query to fetch the image from the database with corresponding title
	//Returns the image in case the image is found in the database
	//Returns null if no image is found in the database
	Image getImageByIdAndTitle(Integer id, String title);

	//The method creates an instance of EntityManager
	//Executes JPQL query to fetch the image from the database with corresponding id
	//Returns the image fetched from the database
	Image getImage(Integer imageId);

	//The method receives the Image object to be updated in the database
	//Creates an instance of EntityManager
	//Starts a transaction
	//The transaction is committed if it is successful
	//The transaction is rolled back in case of unsuccessful transaction
	void updateImage(Image updatedImage);

	//The method receives the Image id of the image to be deleted in the database
	//Creates an instance of EntityManager
	//Starts a transaction
	//Get the image with corresponding image id from the database
	//This changes the state of the image model from detached state to persistent state, which is very essential to use the remove() method
	//If you use remove() method on the object which is not in persistent state, an exception is thrown
	//The transaction is committed if it is successful
	//The transaction is rolled back in case of unsuccessful transaction
	void deleteImage(Integer imageId);

}