import org.junit.Test;
import org.nlogo.api.CompilerException;
import org.nlogo.app.App;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/25/12
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class NetLogoITCase {

    @Test
    public void testNLogo() throws InvocationTargetException, InterruptedException, CompilerException {
            App.main(new String[0]);
            java.awt.EventQueue.invokeAndWait(
                    new Runnable() {
                        public void run() {
                            try {
                                App.app().open("target/integration-tests/drools-test.nlogo");
                            } catch (java.io.IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
            App.app().command("run-tests");
    }
}
