package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.KnowledgeRuntime;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/28/12
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertAgentSetCommand extends InsertCommand {

    @Override
    public Syntax getSyntax() {
        return Syntax.commandSyntax(new int[] {Syntax.WildcardType(), Syntax.WildcardType()});
    }

    @Override
    public void perform(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        KnowledgeRuntime runtime = (KnowledgeRuntime) arguments [ 0 ].get();
        AgentSet a = arguments [ 1 ].getAgentSet();
        runtime.insert(a);
        insertContextSingleton(runtime, context);
    }
}
