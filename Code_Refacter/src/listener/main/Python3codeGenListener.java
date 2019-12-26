package listener.main;

import gen.Python3BaseListener;
import gen.Python3Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Python3codeGenListener extends Python3BaseListener implements ParseTreeListener {


    //모든 basic block의 시작점


    @Override
    public void enterSmall_stmt(Python3Parser.Small_stmtContext ctx) {
        super.enterSmall_stmt(ctx);
    }

    @Override
    public void exitSmall_stmt(Python3Parser.Small_stmtContext ctx) {
        if (ctx.expr_stmt() != null && ctx.expr_stmt().getChildCount() > 1)
            System.out.println(ctx.expr_stmt().getChild(1).toStringTree());
    }

    @Override
    public void enterCompound_stmt(Python3Parser.Compound_stmtContext ctx) {
        super.enterCompound_stmt(ctx);
    }

    @Override
    public void exitCompound_stmt(Python3Parser.Compound_stmtContext ctx) {
        super.exitCompound_stmt(ctx);
    }
}
