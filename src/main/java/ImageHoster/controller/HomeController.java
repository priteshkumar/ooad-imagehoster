package ImageHoster.controller;

import ImageHoster.model.Image;
import ImageHoster.service.ImageService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @Autowired
  private ImageService imageService;

  @RequestMapping("/")
  public String getAllImages(Model model) {
    List<Image> images = imageService.getAllImages().subList(1,5);
    model.addAttribute("images", images);
    return "index";
  }
}