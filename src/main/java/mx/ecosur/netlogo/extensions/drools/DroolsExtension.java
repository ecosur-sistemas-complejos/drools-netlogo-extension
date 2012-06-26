package mx.ecosur.netlogo.extensions.drools;

import org.nlogo.api.DefaultClassManager;
import org.nlogo.api.ExtensionException;
import org.nlogo.api.PrimitiveManager;

/**
 * The Drools extension allows NetLogo simulations to interact with JBoss Rules (Drools)
 * knowledge bases. Users can add change sets to a given KnowledgeBase, create sessions
 * from said knowledge bases (stateful and stateless), insert, update and retract objects
 * from NetLogo space into Drools space.
 *
 * Finally, rules can be fired on said combinations of rules change sets, sessions and
 * facts.
 *
 * @author "Andrew Glenn Waterman" <awaterma@ecosur.mx>, <andrew.waterman@gmail.com>
 */
public class DroolsExtension extends DefaultClassManager {

    @Override
    public void load(PrimitiveManager primitiveManager) throws ExtensionException {

        primitiveManager.addPrimitive("knowledge-base", new KnowledgeBaseReporter());
        primitiveManager.addPrimitive("change-set", new ChangeSetReporter());
        primitiveManager.addPrimitive("add-drl", new AddDRLReporter());
        primitiveManager.addPrimitive("stateful-session", new StatefulSessionReporter());
        primitiveManager.addPrimitive("fire-rules", new FireRulesCommand());
        primitiveManager.addPrimitive("update", new UpdateCommand());
        primitiveManager.addPrimitive("retract", new RetractCommand());
        primitiveManager.addPrimitive("set-global", new SetGlobalCommand());
        primitiveManager.addPrimitive("insert-object", new InsertObjectCommand());

        /* Typed inserts */
        primitiveManager.addPrimitive("insert-number", new InsertNumberCommand());
        primitiveManager.addPrimitive("insert-string", new InsertStringCommand());
        primitiveManager.addPrimitive("insert-agent", new InsertAgentCommand());
        primitiveManager.addPrimitive("insert-agentset", new InsertAgentSetCommand());
        primitiveManager.addPrimitive("insert-turtle", new InsertTurtleCommand());
        primitiveManager.addPrimitive("insert-patch", new InsertPatchCommand());
        primitiveManager.addPrimitive("insert-link", new InsertLinkCommand());
        primitiveManager.addPrimitive("insert-list", new InsertListCommand());

    }
}
