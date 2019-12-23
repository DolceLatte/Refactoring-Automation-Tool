package listener.main;

import generated.Python3BaseListener;
import generated.Python3Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public class Python3codeGenListener extends Python3BaseListener implements ParseTreeListener {

    @Override
    public void enterProgram(Python3Parser.ProgramContext ctx) {
        super.enterProgram(ctx);
    }

    @Override
    public void exitProgram(Python3Parser.ProgramContext ctx) {
        super.exitProgram(ctx);
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
