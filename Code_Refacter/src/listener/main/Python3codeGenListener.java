package listener.main;

import gen.Python3BaseListener;
import gen.Python3Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public class Python3codeGenListener extends Python3BaseListener implements ParseTreeListener {

    @Override
    public void enterSingle_input(Python3Parser.Single_inputContext ctx) {
        super.enterSingle_input(ctx);
    }

    @Override
    public void exitSingle_input(Python3Parser.Single_inputContext ctx) {
        super.exitSingle_input(ctx);
    }

    @Override
    public void enterAtom(Python3Parser.AtomContext ctx) {
        super.enterAtom(ctx);
    }

    @Override
    public void exitAtom(Python3Parser.AtomContext ctx) {
        super.exitAtom(ctx);
    }
}
