package pe.gob.reniec.pki.eaddress.integration.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AlexAnder LLacho
 */
@Controller
public class IndexController extends ParentController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView response = new ModelAndView("index");

        response.addObject("baseUrl", baseUrl);
        return response;
    }

}
