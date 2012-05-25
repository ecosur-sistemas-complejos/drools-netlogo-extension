import mx.ecosur.netlogo.extensions.drools.ChangeSetReporter;
import mx.ecosur.netlogo.extensions.drools.KnowledgeBaseReporter;
import mx.ecosur.netlogo.extensions.drools.StatefulSessionReporter;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.StatefulSession;
import org.drools.impl.StatefulKnowledgeSessionImpl;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Basic tests for the Drools plugin.
 */
public class BasicDroolsExtensionTest {

    @Test
    public void testKnowledgeBaseReporter() throws ExtensionException, LogoException {
        Argument a = mock(Argument.class);
        Argument[] args = new Argument[] { a };

        KnowledgeBaseReporter r = new KnowledgeBaseReporter();
        KnowledgeBase b = (KnowledgeBase) r.report(args,mock(Context.class));

        assertNotNull(b);
        assertTrue(b instanceof KnowledgeBase);
    }

    @Test
    public void testChangeSetReporter() throws ExtensionException, LogoException {
        ChangeSetReporter r = new ChangeSetReporter();

        /* Mocks */
        Argument arg = mock(Argument.class);
        when(arg.getString()).thenReturn("target/test-classes/rules/test-changeset.xml");
        Context c = mock(Context.class);
        Argument[] args = new Argument[] { arg };

        /* Test execution */
        KnowledgeBase cb = (KnowledgeBase) r.report(args,c);
        assertNotNull(cb);
        assertTrue(cb.getKnowledgePackages().size() == 1);
    }

    @Test
    public void testStatefulSessionReporter() throws ExtensionException, LogoException {
        Argument a = mock(Argument.class);
        Argument[] args = new Argument[] { a };
        Context context = mock(Context.class);

        KnowledgeBaseReporter kbr = new KnowledgeBaseReporter();
        KnowledgeBase b = (KnowledgeBase) kbr.report(args, context);

        when(a.get()).thenReturn(b);

        StatefulSessionReporter r = new StatefulSessionReporter();
        StatefulKnowledgeSession session = (StatefulKnowledgeSessionImpl) r.report(args, context);
        assertNotNull(session);
    }
}
