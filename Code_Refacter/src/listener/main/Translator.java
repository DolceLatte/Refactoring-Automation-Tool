package listener.main;

import generated.Python3Lexer;
import generated.Python3Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;



public class Translator {
    enum OPTIONS {
        PYTHON3CODEGEN, ERROR
    }

    private static OPTIONS getOption(String[] args) {
        if (args.length < 1)
            return OPTIONS.PYTHON3CODEGEN;

        if (args[0].startsWith("-b")
                || args[0].startsWith("-B"))
            return OPTIONS.PYTHON3CODEGEN;

        return OPTIONS.ERROR;
    }

    public static void main(String[] args) throws Exception {
        CharStream codeCharStream = CharStreams.fromFileName("test.py");
        Python3Lexer lexer = new Python3Lexer(codeCharStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Python3Parser parser = new Python3Parser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree());

        ParseTreeWalker walker = new ParseTreeWalker();
        switch (getOption(args)) {
            case PYTHON3CODEGEN:
                walker.walk(new Python3codeGenListener(), tree);
                break;
            default:
                break;
        }
    }
}