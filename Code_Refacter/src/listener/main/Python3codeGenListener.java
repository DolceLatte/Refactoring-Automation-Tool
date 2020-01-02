package listener.main;

import gen.Python3BaseListener;
import gen.Python3Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static listener.main.Python3codeGenListenerHelper.*;

class Stmt {
    int _linenumber;
    String _type;

    public Stmt(int i, String s) {
        this._linenumber = i;
        this._type = s;
    }
}

public class Python3codeGenListener extends Python3BaseListener implements ParseTreeListener {

    boolean import_flag = false;

    int lineNumber = 0;

    HashMap<Integer, String> hashMap = new HashMap<>();

    @Override
    public void exitDecl(Python3Parser.DeclContext ctx) {
        //해쉬맵을 리스트로 변환
        System.out.println("중복된 코드");
        PriorityQueue<Stmt> stmts = new PriorityQueue<>();
        for (int i : hashMap.keySet()) {
            stmts.add(new Stmt(i, hashMap.get(i)));
        }
        while (!stmts.isEmpty()){
        }

    }

    @Override
    public void enterFile_input(Python3Parser.File_inputContext ctx) {
        System.out.println("---------------Comprehensive comment---------------");
        for (int i = 0; i < ctx.stmt().size(); i++) {
            if (import_flag && (ctx.stmt(i).start.getText().equals("from") || ctx.stmt(i).start.getText().equals("import"))) {
                System.out.println("Always place an import statement at the top of the file in Line :" + i);
            }
            if (!(ctx.stmt(i).start.getText().equals("from") || ctx.stmt(i).start.getText().equals("import"))) {
                import_flag = true;
            }
        }
        System.out.println();
    }

    @Override
    public void enterWhile_stmt(Python3Parser.While_stmtContext ctx) {
        if (ishasElseStmt(ctx)) {
            System.out.print("Clear else_stmt after While_loop!");
        }
    }

    @Override
    public void enterFor_stmt(Python3Parser.For_stmtContext ctx) {
        if (ishasElseStmt(ctx)) {
            System.out.print("Clear else_stmt after For_loop!");
        }
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if (node.getSymbol().getText().equals("\n")) {
            lineNumber++;
        } else {
            int type = node.getSymbol().getType();
            if (hashMap.containsKey(lineNumber)) {
                hashMap.put(lineNumber, hashMap.get(lineNumber).concat(Integer.toString(type)));
            } else {
                hashMap.put(lineNumber, Integer.toString(type));
            }
        }
    }

    //모든 basic block의 시작노드
    @Override
    public void enterSmall_stmt(Python3Parser.Small_stmtContext ctx) {
//        System.out.println(ctx);
    }

    @Override
    public void enterStmt(Python3Parser.StmtContext ctx) {
        if (ctx.depth() == 4) System.out.print((lineNumber + 1) + ": ");
    }

    @Override
    public void exitStmt(Python3Parser.StmtContext ctx) {
        if (ctx.depth() == 4) System.out.println();
    }

    @Override
    public void exitSmall_stmt(Python3Parser.Small_stmtContext ctx) {
//        System.out.println(ctx);
    }

    public List<Integer> getKey(HashMap<Integer, String> m, String value) {
        List<Integer> list = new LinkedList<>();
        for (int o : m.keySet()) {
            if (m.get(o).equals(value)) {
                list.add(o);
            }
        }
        return list;
    }

}
