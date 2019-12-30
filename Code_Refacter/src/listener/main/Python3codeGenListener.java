package listener.main;

import gen.Python3BaseListener;
import gen.Python3Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public class Python3codeGenListener extends Python3BaseListener implements ParseTreeListener {

    boolean import_flag = false;

    @Override
    public void enterFile_input(Python3Parser.File_inputContext ctx) {
        for (int i = 0; i < ctx.stmt().size(); i++) {
            if (import_flag && (ctx.stmt(i).start.getText().equals("from") || ctx.stmt(i).start.getText().equals("import"))) {
                System.out.println("bad Import Location" + i);
            }
            if (!(ctx.stmt(i).start.getText().equals("from") || ctx.stmt(i).start.getText().equals("import"))) {
                import_flag = true;
            }
        }

    }

    @Override
    public void enterStmt(Python3Parser.StmtContext ctx) {

    }

    @Override
    public void exitStmt(Python3Parser.StmtContext ctx) {
        super.exitStmt(ctx);
    }

    //모든 basic block의 시작노드
    @Override
    public void enterSmall_stmt(Python3Parser.Small_stmtContext ctx) {
    }

    @Override
    public void exitSmall_stmt(Python3Parser.Small_stmtContext ctx) {

    }

    @Override
    public void enterImport_stmt(Python3Parser.Import_stmtContext ctx) {

    }

    @Override
    public void exitImport_stmt(Python3Parser.Import_stmtContext ctx) {

    }
}
