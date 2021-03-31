package ImageHoster.service;

import ImageHoster.model.Image;
import ImageHoster.repository.ImageRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

  @Autowired
  private ImageRepository imageRepository;

  //Call the getAllImages() method in the Repository and obtain a List of all the images in the database
  @Override
public List<Image> getAllImages() {
    return imageRepository.getAllImages();
  }


  //The method calls the createImage() method in the Repository and passes the image to be persisted in the database
  @Override
public void uploadImage(Image image) {
    imageRepository.uploadImage(image);
  }


  //The method calls the getImageByTitle() method in the Repository and passes the title of the image to be fetched
  @Override
public Image getImageByIdAndTitle(Integer id, String title) {
    return imageRepository.getImageByIdAndTitle(id, title);
  }

  //The method calls the getImage() method in the Repository and passes the id of the image to be fetched
  @Override
public Image getImage(Integer imageId) {
    return imageRepository.getImage(imageId);
  }

  //The method calls the updateImage() method in the Repository and passes the Image to be updated in the database
  @Override
public void updateImage(Image updatedImage) {
    imageRepository.updateImage(updatedImage);
  }

  //The method calls the deleteImage() method in the Repository and passes the Image id of the image to be deleted in the database
  @Override
public void deleteImage(Integer imageId) {
    imageRepository.deleteImage(imageId);
  }

}
