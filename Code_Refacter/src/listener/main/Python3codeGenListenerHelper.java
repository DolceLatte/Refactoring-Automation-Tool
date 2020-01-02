package listener.main;

import gen.Python3Parser;

public class Python3codeGenListenerHelper {

    public static boolean ishasElseStmt(Python3Parser.For_stmtContext ctx) {
        return ctx.getChildCount() >= 9;
    }

    public static boolean ishasElseStmt(Python3Parser.While_stmtContext ctx) {
        return ctx.getChildCount() >= 7;
    }
}
