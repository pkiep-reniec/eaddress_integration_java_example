package pe.gob.reniec.pki.eaddress.integration.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.gob.reniec.eaddress.sdk.ReniecEAddressClient;
import pe.gob.reniec.eaddress.sdk.dto.ConfigAga;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author AlexAnder LLacho
 */
public class ParentController {

    private static final Logger logger = LoggerFactory.getLogger(ParentController.class);

    protected String baseUrl = "http://localhost:8080/integration_java_demo";

    protected ReniecEAddressClient getEAddressClient(String pathConfig, ConfigAga oConfigAga) {
        try {
            ReniecEAddressClient oClient = new ReniecEAddressClient(pathConfig, oConfigAga);

            return oClient;
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));

            logger.error(sw.toString());
        }

        return null;
    }

}
