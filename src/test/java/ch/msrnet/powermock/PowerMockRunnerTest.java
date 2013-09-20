package ch.msrnet.powermock;

import ch.msrnet.Setting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

@PrepareForTest(Setting.class)
@RunWith(PowerMockRunner.class)
public class PowerMockRunnerTest {

    private final String mockedString = "mocked String!";

    @Test
    public void mockTest() {
        PowerMockito.mockStatic(Setting.class);
        when(Setting.getString()).thenReturn(mockedString);
        assert (Setting.getString().equals(mockedString));
    }
}