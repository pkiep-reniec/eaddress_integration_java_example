package pe.gob.reniec.pki.eaddress.integration.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import pe.gob.reniec.eaddress.sdk.ReniecEAddressClient;
import pe.gob.reniec.eaddress.sdk.dto.ConfigAga;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/**
 * @author AlexAnder LLacho
 */
public class ParentController {

    private static final Logger logger = LoggerFactory.getLogger(ParentController.class);

    @Value("${aga.uri}")
    private String agaUri;
    @Value("${aga.timestamp}")
    private String agaTimestamp;
    @Value("${aga.certificate.id}")
    private String agaCertificateId;
    @Value("${aga.password}")
    private String agaPassword;

    protected ReniecEAddressClient getEAddressClient() {
        ReniecEAddressClient reniecEAddressClient;

        try {
            ConfigAga oConfigAga = new ConfigAga();
            oConfigAga.setAgaUri(agaUri);
            oConfigAga.setTimestamp(agaTimestamp);
            oConfigAga.setCertificateId(agaCertificateId);
            oConfigAga.setSecretPassword(agaPassword);

            String configFile = Objects.requireNonNull(getClass().getClassLoader().getResource("reniec_eaddress.json")).getFile();
            reniecEAddressClient = new ReniecEAddressClient(configFile, oConfigAga);

            return reniecEAddressClient;
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));

            logger.error(sw.toString());
        }

        return null;
    }

}
