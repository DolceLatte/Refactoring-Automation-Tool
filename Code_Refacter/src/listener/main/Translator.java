package listener.main;

import gen.Python3Lexer;
import gen.Python3Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;


public class Translator extends ParseTreeWalker {
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
//        AstPrinter astPrinter = new AstPrinter();
//        astPrinter.print(parser.decl());

        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.decl();
        switch (getOption(args)) {
            case PYTHON3CODEGEN:
                walker.walk(new Python3codeGenListener(), tree);
                break;
            default:
                break;
        }
    }
}