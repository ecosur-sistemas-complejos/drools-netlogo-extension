package mx.ecosur.netlogo.extensions.drools;

import org.drools.KnowledgeBaseFactory;
import org.nlogo.api.*;

/**
 * Returns a new Drools KnowledgeBase for working with KnowledgePackages.
 */
public class KnowledgeBaseReporter extends DefaultReporter {

    @Override
    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[0], Syntax.WildcardType());
    }

    @Override
    public Object report(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        return KnowledgeBaseFactory.newKnowledgeBase();
    }
}
