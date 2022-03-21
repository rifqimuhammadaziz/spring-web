package rifqimuhammadaziz.springweb.controllers;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rifqimuhammadaziz.springweb.service.ReportService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpSession session;

    @GetMapping("/products")
    public void getProductReport() throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Product List.pdf\"");
        String searchKey = (String) session.getAttribute("searchKey");
        JasperPrint jasperPrint = reportService.generateJasperPrint(searchKey);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
