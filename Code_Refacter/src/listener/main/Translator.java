package listener.main;

import gen.Python3Lexer;
import gen.Python3Parser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.util.Arrays;

public class Translator extends ParseTreeWalker {

    public static void main(String[] args) throws Exception {
        StringBuilder builder = new StringBuilder();
        for(String s : args) {
            builder.append(s);
        }
        String str = builder.toString();
        CharStream codeCharStream = CharStreams.fromFileName(str);
        Python3Lexer lexer = new Python3Lexer(codeCharStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Python3Parser parser = new Python3Parser(tokens);
//        AstPrinter astPrinter = new AstPrinter();
//        astPrinter.print(parser.decl());

        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTree tree = parser.decl();

        walker.walk(new Python3codeGenListener(), tree);

    }
}