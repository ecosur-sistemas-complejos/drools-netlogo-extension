package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.KnowledgeRuntime;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/25/12
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertPatchCommand extends InsertCommand {

    @Override
    public Syntax getSyntax() {
        return Syntax.commandSyntax(new int[] {Syntax.WildcardType(), Syntax.WildcardType()});
    }

    @Override
    public void perform(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        KnowledgeRuntime runtime = (KnowledgeRuntime) arguments [ 0 ].get();
        Patch p = arguments [ 1 ].getPatch();
        runtime.insert(p);
        insertContextSingleton(runtime, context);
    }

}
