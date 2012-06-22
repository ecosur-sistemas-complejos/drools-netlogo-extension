import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nlogo.api.Dump;
import org.nlogo.headless.HeadlessWorkspace;

import java.io.IOException;

import static junit.framework.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 6/22/12
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class NetLogoProjectITCase {

    HeadlessWorkspace ws;

    @Before
    public void setup() throws IOException {
        ws = HeadlessWorkspace.newInstance();
        ws.open("target/integration-tests/drools-test.nlogo");
        ws.command("setup");
    }

    @After
    public void tearDown() throws InterruptedException {
        ws.dispose();
    }

    @Test
    public void testWS() {
        ws.command("run-unit-tests");
        assertTrue("Update was not successful!", (Boolean) ws.report("update-successful?"));
    }
}
