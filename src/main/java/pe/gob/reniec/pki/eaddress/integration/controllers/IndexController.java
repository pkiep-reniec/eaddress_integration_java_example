package pe.gob.reniec.pki.eaddress.integration.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AlexAnder LLacho
 */
@Controller
public class IndexController extends ParentController {

    @Value("${app.url}")
    private String baseUrl;

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView response = new ModelAndView("index");

        response.addObject("baseUrl", baseUrl);
        return response;
    }
}
