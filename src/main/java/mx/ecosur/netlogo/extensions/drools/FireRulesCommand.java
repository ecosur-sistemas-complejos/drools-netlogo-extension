package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.StatefulKnowledgeSession;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/23/12
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class FireRulesCommand extends DefaultCommand {

    @Override
    public Syntax getSyntax() {
        return Syntax.commandSyntax(new int[] {Syntax.ReadableType()});
    }

    @Override
    public void perform(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        StatefulKnowledgeSession s = (StatefulKnowledgeSession) arguments [ 0 ].get();
        s.fireAllRules();
    }
}
