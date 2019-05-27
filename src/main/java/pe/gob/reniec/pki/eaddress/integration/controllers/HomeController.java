package pe.gob.reniec.pki.eaddress.integration.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pe.gob.reniec.eaddress.sdk.ReniecEAddressClient;
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

    @RequestMapping("/home")
    public ModelAndView getIndex(
            @RequestParam("dni") String dni,
            @RequestParam("subject") String subject,
            @RequestParam("tag") String tag,
            @RequestParam("message") String message
    ) {
        ModelAndView response = new ModelAndView("home");

        List<Attachment> attachments = new ArrayList<>();
        Attachment attachment1 = new Attachment();
        attachment1.setName("Archivo demo 1");
        attachment1.setUrl("http://www.reniec.gob.pe/portal/pdf/01_dnie.pdf");

        Attachment attachment2 = new Attachment();
        attachment2.setName("Archivo demo 2");
        attachment2.setUrl("http://www.reniec.gob.pe/Transparencia/intranet/imagenes/noticias/comunicado/POINF-RJ-000104-2017-JNAC-RENIEC.pdf");

        attachments.add(attachment1);
        attachments.add(attachment2);

        String jsonAttachments = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonAttachments = objectMapper.writeValueAsString(attachments);

            Message oMessage = new Message();
            oMessage.setDocType("dni");
            oMessage.setDoc(dni);
            oMessage.setSubject(subject);
            oMessage.setMessage(message);
            oMessage.setRep("");
            oMessage.setTag(tag);
            oMessage.setAttachments(jsonAttachments);

            ConfigAga oConfigAga = new ConfigAga();
            oConfigAga.setAgaUri("http://127.0.0.1:8080/refirma-aga/rest/service/sign-file");
            oConfigAga.setTimestamp("false");
            oConfigAga.setCertificateId("certificate");
            oConfigAga.setSecretPassword("holamundo");

            ReniecEAddressClient demo = getEAddressClient(getClass().getClassLoader().getResource("reniec_eaddress.json").getFile(), oConfigAga);
            ApiResponse result = demo.messageSingle(oMessage);

            String resultMessage = result.getMessage();

            if (result.getSuccess()) {
                resultMessage = "Mensaje enviado.";
            }

            response.addObject("response", resultMessage);
            response.addObject("baseUrl", baseUrl);

        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
        }

        return response;
    }

}
