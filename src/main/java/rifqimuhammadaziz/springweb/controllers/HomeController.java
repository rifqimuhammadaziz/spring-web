package rifqimuhammadaziz.springweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rifqimuhammadaziz.springweb.dto.SearchFormData;
import rifqimuhammadaziz.springweb.entity.Product;
import rifqimuhammadaziz.springweb.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession session;

    @GetMapping
    public String home(Model model) {
        String title = "Welcome to Spring Application";
        model.addAttribute("title", title);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String viewAdd(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("searchForm", new SearchFormData());
        return "product/add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        productService.addProduct(product);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String viewAdd(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("searchForm", new SearchFormData());
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(Product product, Model model) {
        productService.updateProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchData(SearchFormData searchFormData, Model model) {
        String title = "Welcome to Spring Application";
        model.addAttribute("title", title);
        model.addAttribute("searchForm", searchFormData);
        session.setAttribute("searchKey", searchFormData.getKeyword());
        model.addAttribute("products", productService.findByName(searchFormData.getKeyword()));
        return "index";
    }

}
