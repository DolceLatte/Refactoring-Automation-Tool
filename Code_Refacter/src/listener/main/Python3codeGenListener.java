package listener.main;

import gen.Python3BaseListener;
import gen.Python3Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static listener.main.Python3codeGenListenerHelper.*;

public class Python3codeGenListener extends Python3BaseListener implements ParseTreeListener {

    boolean import_flag = false;
    int lineNumber = 1;

    HashMap<Integer, String> hashMap = new HashMap<>();

    @Override
    public void exitDecl(Python3Parser.DeclContext ctx) {
        HashMap<String, CodePatternInfo> find = findDuplicatedCode(hashMap);
        System.out.println();
        for (CodePatternInfo c : find.values()) {
            if (c.count > 1)
                System.out.println("code line : " + c.linenumber.toString() + " have a duplicated code segment!");
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
        //중복되는 코드의 패턴을 해쉬맵에 라인번호와 함께 저장
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
        if (ctx.depth() == 4) System.out.print((lineNumber) + ": ");
    }

    @Override
    public void exitStmt(Python3Parser.StmtContext ctx) {
        if (ctx.depth() == 4) System.out.println();
    }

    @Override
    public void exitSmall_stmt(Python3Parser.Small_stmtContext ctx) {
//        System.out.println(ctx);
    }

    public HashMap<String, CodePatternInfo> findDuplicatedCode(HashMap<Integer, String> code) {
        //패턴별로 객체를 생성
        HashMap<String, CodePatternInfo> find = new HashMap<>();
        for (int key : code.keySet()) {
            List<Integer> list = new ArrayList<>();
            String value = code.get(key);
            if (find.containsKey(value)) {
                CodePatternInfo codePatternInfo = find.get(value);
                codePatternInfo.count++;
                codePatternInfo.linenumber.add(key);
                find.put(value, codePatternInfo);
            } else {
                list.add(key);
                find.put(value, new CodePatternInfo(list, 1));
            }
        }
        return find;
    }

}

class CodePatternInfo {
    List<Integer> linenumber;
    int count;

    public CodePatternInfo(List<Integer> linenumber, int count) {
        this.linenumber = linenumber;
        this.count = count;
    }
}

class Stmt {
    int _linenumber;
    String _type;

    public Stmt(int i, String s) {
        this._linenumber = i;
        this._type = s;
    }
}