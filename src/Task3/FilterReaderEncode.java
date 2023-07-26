package Task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class FilterReaderEncode extends FilterReader {
    protected FilterReaderEncode(Reader in) {
        super(in);
    }

    //для зсуву на 1
    public int read() throws IOException{
        int b=super.read();
        return (b!=-1)?(b+1):(-1);
    }
    //для зсуву на символ с

    public int read(char c) throws IOException{
        int b=super.read();
        return (b!=-1)?(b+(int)c):(-1);
    }



}