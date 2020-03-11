package pe.gob.reniec.pki.eaddress.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pe.gob.reniec.eaddress.sdk.ReniecEAddressClient;
import pe.gob.reniec.eaddress.sdk.common.Constants;
import pe.gob.reniec.eaddress.sdk.dto.ApiResponse;
import pe.gob.reniec.eaddress.sdk.dto.Attachment;
import pe.gob.reniec.eaddress.sdk.dto.ConfigAga;
import pe.gob.reniec.eaddress.sdk.dto.Message;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AlexAnder LLacho
 */
@Controller
public class HomeController extends ParentController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Value("${app.url}")
    private String baseUrl;

    @RequestMapping("/home")
    public ModelAndView getIndex(
            @RequestParam("dni") String dni,
            @RequestParam("subject") String subject,
            @RequestParam("tag") String tag,
            @RequestParam("message") String message
    ) {
        ModelAndView response = new ModelAndView("home");

        try {
            logger.info("Sending notification to eAddress service test: ");

            ReniecEAddressClient reniecEAddressClient = getEAddressClient();

            List<Attachment> attachments = new ArrayList<>();
            attachments.add(new Attachment("Archivo demo 1", "https://www.gob.pe/859-plataforma-de-autenticacion-id-peru"));
            attachments.add(new Attachment("Archivo demo 2", "https://www.gob.pe/859-plataforma-de-autenticacion-id-peru"));
            attachments.add(new Attachment("Archivo demo 3", "https://www.gob.pe/859-plataforma-de-autenticacion-id-peru"));

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonAttachments = objectMapper.writeValueAsString(attachments);

            Message oMessage = new Message();
            oMessage.setDocType(Constants.TYPE_DOC_DNI);
            oMessage.setDoc(dni);
            oMessage.setSubject(subject.trim());
            oMessage.setMessage(message.trim());
            oMessage.setTag(tag.trim());
            oMessage.setAttachments(jsonAttachments);

            ApiResponse result = reniecEAddressClient.sendSingleNotification(oMessage);

            response.addObject("response", result.getMessage());
            response.addObject("baseUrl", baseUrl);

            if (!result.getSuccess()) {
                logger.error("Error sending notication to eAddress: ".concat(result.toString()));
            }
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
        }

        return response;
    }

}
