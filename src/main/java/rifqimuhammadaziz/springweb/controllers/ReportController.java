package rifqimuhammadaziz.springweb.controllers;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import rifqimuhammadaziz.springweb.service.ReportService;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private HttpServletResponse response;

    @GetMapping("/products")
    public void getProductReport() throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"Product List.pdf\"");
        JasperPrint jasperPrint = reportService.generateJasperPrint();
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}
