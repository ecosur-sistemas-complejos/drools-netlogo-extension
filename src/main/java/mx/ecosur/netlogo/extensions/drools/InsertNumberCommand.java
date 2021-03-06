package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.KnowledgeRuntime;
import org.nlogo.api.*;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/23/12
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class InsertNumberCommand extends InsertCommand {

    @Override
    public Syntax getSyntax() {
        return Syntax.commandSyntax(new int[] {Syntax.WildcardType(), Syntax.WildcardType()});
    }

    @Override
    public void perform(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        KnowledgeRuntime runtime = (KnowledgeRuntime) arguments [ 0 ].get();
        /* Numbers are always doubles in NetLogo */
        Double d = arguments [ 1 ].getDoubleValue();
        runtime.insert(d);
        insertContextSingleton(runtime, context);
    }
}
