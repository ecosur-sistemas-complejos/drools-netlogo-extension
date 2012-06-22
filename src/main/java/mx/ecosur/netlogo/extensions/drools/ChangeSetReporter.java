package mx.ecosur.netlogo.extensions.drools;

import org.drools.builder.*;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.nlogo.api.*;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: awaterma
 * Date: 5/23/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ChangeSetReporter extends DefaultReporter {

    static String topDir;

    static {
        try {
            File jarFile = new File (ChangeSetReporter.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
            topDir = jarFile.getParentFile().getParentFile().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Syntax getSyntax() {
        return Syntax.reporterSyntax(new int[] {Syntax.StringType()}, Syntax.WildcardType());
    }

    @Override
    public Object report(Argument[] arguments, Context context) throws ExtensionException, LogoException {
        String file = arguments[0].getString();
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        Resource resource = ResourceFactory.newFileResource(topDir + File.separator + file);
        kbuilder.add(resource, ResourceType.CHANGE_SET);
        if (kbuilder.hasErrors()) {
            KnowledgeBuilderErrors errors = kbuilder.getErrors();
            StringBuffer es = new StringBuffer();
            for (KnowledgeBuilderError e : errors) {
                es.append(e.getMessage());
            }

            throw new RuntimeException("Errors found while working with changeset: " + es.toString());
        }
        return kbuilder.newKnowledgeBase();

    }
}
