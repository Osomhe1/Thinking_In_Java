import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SourceCode {
    public static void main(String[] args) {
        String s = TextFIle.read("SourceCode.java");
        Matcher mInput = Pattern.compile(" ", Pattern.DOTAll).mather(s);
        if(mInput.find())
            s = mInput.group(1);
        s =s.replaceAll("{2,}", "");
        s= s.replaceAll("(?m)^ +", "");
        System.out.print(s);
        s = s.replaceFirst("[class]", "(CLASS)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[class]");
        Matcher m = p.matcher(s);
        while(m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        m.appendTail(sbuf);
        System.out.print(sbuf);
    }

    private static class TextFIle {

        public TextFIle() {
        }
    }
}
