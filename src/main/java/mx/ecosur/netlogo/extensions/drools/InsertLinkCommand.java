package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.KnowledgeRuntime;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/28/12
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class InsertLinkCommand extends InsertCommand {
    @Override
    public Syntax getSyntax() {
        return Syntax.commandSyntax(new int[] {Syntax.ReadableType(), Syntax.ReadableType()});
    }

    @Override
    public void perform(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        KnowledgeRuntime runtime = (KnowledgeRuntime) arguments [ 0 ].get();
        Link l = arguments [ 1 ].getLink();
        runtime.insert(l);
        insertContextSingleton(runtime, context);
    }
}
