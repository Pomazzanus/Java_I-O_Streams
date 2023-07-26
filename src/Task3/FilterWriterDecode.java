package Task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.FilterWriter;
import java.io.Writer;

public class FilterWriterDecode extends FilterWriter {
    protected FilterWriterDecode(Writer out) {
        super(out);
    }
    //для зсуву на 1
    public void write(String str)throws IOException {
        StringBuilder sb=new StringBuilder();
        char[] arrChar=str.toCharArray();
        for (char c : arrChar) {
            sb.append((char) ((int)c - 1));
        }
        super.write(sb.toString());
    }

    //для зсуву на символ d
    public void write(String str, char d)throws IOException {
        StringBuilder sb=new StringBuilder();
        char[] arrChar=str.toCharArray();
        for (char c : arrChar) {
            sb.append((char) ((int)c - (int)d));
        }
        super.write(sb.toString());
    }
}
