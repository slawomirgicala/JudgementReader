import java.util.Map;

public interface IParser {

    void parseDir(Map map, String dirPath);

    void parseOne(Map map, String filePath);

}
