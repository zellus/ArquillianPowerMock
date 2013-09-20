package ch.msrnet.arquillian;

import ch.msrnet.Setting;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.mockito.Mockito.when;

@PrepareForTest(Setting.class)
@RunWith(Arquillian.class)
public class ArquillianPowerMockIT {

    private final String mockedString = "mocked String!";

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                ;
    }

//    @Ignore
    @Test
    public void mockTest() {
        PowerMockito.mockStatic(Setting.class);
        when(Setting.getString()).thenReturn(mockedString);
        assert (Setting.getString().equals(mockedString));
    }

//    @Ignore
    @Test
    public void smokeTest() {
        Assert.assertTrue("smoke tests", true);
    }
}
