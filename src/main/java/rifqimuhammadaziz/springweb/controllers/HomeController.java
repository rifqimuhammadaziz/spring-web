package rifqimuhammadaziz.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rifqimuhammadaziz.springweb.entity.Product;
import rifqimuhammadaziz.springweb.service.ProductService;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String home(Model model) {
        String title = "Welcome to Spring Application";
        model.addAttribute("title", title);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String viewAddProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/save")
    public String saveProduct(Product product, Model model) {
        productService.addProduct(product);

        return "redirect:/";
    }
}
