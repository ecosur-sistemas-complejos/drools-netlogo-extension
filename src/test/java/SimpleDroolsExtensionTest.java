import mx.ecosur.netlogo.extensions.drools.*;
import org.drools.KnowledgeBase;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Before;
import org.junit.Test;
import org.nlogo.api.Argument;
import org.nlogo.api.Context;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.LogoException;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/24/12
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleDroolsExtensionTest {

    KnowledgeBase base;

    @Before
    public void setUp() throws ExtensionException, LogoException {

        /* Setup knowledge base with ruleset */
        ChangeSetReporter r = new ChangeSetReporter();
        Argument arg = mock(Argument.class);
        when(arg.getString()).thenReturn("target/test-classes/rules/test-changeset.xml");
        Context c = mock(Context.class);
        Argument[] args = new Argument[] { arg };
        base = (KnowledgeBase) r.report(args,c);
    }

    @Test
    public void testInsert() throws ExtensionException, LogoException {
        /* Setup mocking */
        Argument kA = mock(Argument.class);
        when(kA.get()).thenReturn(base);
        Argument[] args = new Argument[] { kA };
        Context context = mock(Context.class);

        StatefulSessionReporter sreporter = new StatefulSessionReporter();
        StatefulKnowledgeSession session = (StatefulKnowledgeSession) sreporter.report(args, context);

        InsertNumberCommand ic = new InsertNumberCommand();
        Argument arg1 = mock(Argument.class);
        when(arg1.get()).thenReturn(session);
        Argument arg2 = mock(Argument.class);
        when(arg2.get()).thenReturn("this is a test string");
        args = new Argument[] { arg1, arg2 };
        ic.perform(args,context);
    }

    @Test
    public void testFireRules() throws ExtensionException, LogoException {
        /* Setup mocking */
        Argument kA = mock(Argument.class);
        when(kA.get()).thenReturn(base);
        Argument[] args = new Argument[] { kA };
        Context context = mock(Context.class);

        StatefulSessionReporter sreporter = new StatefulSessionReporter();
        StatefulKnowledgeSession session = (StatefulKnowledgeSession) sreporter.report(args, context);

        InsertNumberCommand ic = new InsertNumberCommand();
        Argument arg1 = mock(Argument.class);
        when(arg1.get()).thenReturn(session);
        Argument arg2 = mock(Argument.class);
        when(arg2.get()).thenReturn("this is a test string");
        args = new Argument[] { arg1, arg2 };
        ic.perform(args,context);

        FireRulesCommand fr = new FireRulesCommand();
        args = new Argument[] { arg1 };
        fr.perform(args,context);
    }

    @Test
    public void testSetGlobalAndFireRules() throws ExtensionException, LogoException {
        /* Setup mocking */
        Argument kA = mock(Argument.class);
        when(kA.get()).thenReturn(base);
        Argument[] args = new Argument[] { kA };
        Context context = mock(Context.class);

        StatefulSessionReporter sreporter = new StatefulSessionReporter();
        StatefulKnowledgeSession session = (StatefulKnowledgeSession) sreporter.report(args, context);

        SetGlobalCommand sgc = new SetGlobalCommand();
        Argument arg1 = mock(Argument.class);
        Argument arg2 = mock(Argument.class);
        Argument arg3 = mock(Argument.class);
        when(arg1.get()).thenReturn(session);
        when(arg2.getString()).thenReturn("globalString");
        when(arg3.get()).thenReturn("this is a test string");
        args = new Argument[] { arg1, arg2, arg3 };
        context = mock(Context.class);
        sgc.perform(args,context);

        InsertStringCommand ic = new InsertStringCommand();
        arg1 = mock(Argument.class);
        when(arg1.get()).thenReturn(session);
        arg2 = mock(Argument.class);
        when(arg2.get()).thenReturn("this is a test string");
        args = new Argument[] { arg1, arg2 };
        context = mock(Context.class);
        ic.perform(args,context);

        FireRulesCommand fr = new FireRulesCommand();
        args = new Argument[] { arg1 };
        context = mock(Context.class);
        fr.perform(args,context);
    }

}
