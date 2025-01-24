package demoapp.controller;

import demoapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @GetMapping("/images")
    public String listImages(Model model) {
        model.addAttribute("images", imageService.listImages());
        return "listImages";
    }

    @PostMapping("/vote")
    public String voteImage(@RequestParam("id") Long id) {
        imageService.voteImage(id);
        return "redirect:/images";
    }
}
