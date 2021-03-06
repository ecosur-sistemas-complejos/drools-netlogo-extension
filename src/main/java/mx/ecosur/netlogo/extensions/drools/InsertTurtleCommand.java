package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.KnowledgeRuntime;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/25/12
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertTurtleCommand extends InsertCommand {

    @Override
    public Syntax getSyntax() {
        return Syntax.commandSyntax(new int[] {Syntax.AgentType(), Syntax.WildcardType()});
    }

    @Override
    public void perform(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        KnowledgeRuntime runtime = (KnowledgeRuntime) arguments [ 0 ].get();
        Turtle t = arguments [ 1 ].getTurtle();
        runtime.insert(t);
        insertContextSingleton(runtime, context);
    }
}
