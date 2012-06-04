package mx.ecosur.netlogo.extensions.drools;

import org.drools.KnowledgeBase;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/23/12
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class StatefulSessionReporter extends DefaultReporter {

    @Override
    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[] {Syntax.ReadableType()},
                Syntax.ReadableType());
    }

    @Override
    public Object report(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        KnowledgeBase kBase = (KnowledgeBase) arguments[ 0 ].get();
        return kBase.newStatefulKnowledgeSession();
    }
}
