package ch.msrnet.powermock;

import ch.msrnet.Setting;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.mockito.Mockito.when;

@PrepareForTest(Setting.class)
public class PowerMockRuleTest {

    private final String mockedString = "mocked String!";

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void mockTest() {
        PowerMockito.mockStatic(Setting.class);
        when(Setting.getString()).thenReturn(mockedString);
        assert (Setting.getString().equals(mockedString));
    }
}