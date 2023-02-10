package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FilepathConstants {
    TESTDATA_FILEPATH("src/test/resources/testdata/testdata.json");

    private final String filePath;
}
