package mx.ecosur.netlogo.extensions.drools;

import org.drools.runtime.KnowledgeRuntime;
import org.drools.runtime.rule.FactHandle;
import org.nlogo.api.Context;
import org.nlogo.api.DefaultCommand;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 6/5/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class InsertCommand extends DefaultCommand {

    protected void insertContextSingleton (KnowledgeRuntime runtime, Context context) {
        FactHandle ch = runtime.getFactHandle(context);
        if (ch != null) {
            runtime.retract(ch);
        }
        runtime.insert(context);
    }

}
