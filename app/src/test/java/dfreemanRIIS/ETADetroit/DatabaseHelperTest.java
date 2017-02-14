package dfreemanRIIS.ETADetroit;

import android.test.mock.MockContext;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import dfreemanRIIS.ETADetroit.repository.Repository;

import static junit.framework.Assert.assertEquals;

public class DatabaseHelperTest {

    @Mock
    MockContext mockContext;
    @Mock
    Repository mockRepository;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() {
        mockContext = new MockContext();
        mockRepository = org.mockito.Mockito.mock(Repository.class);
    }

    @Test
    public void testOne() {
        Mockito.when(mockRepository.getTrainCompanyName(1, mockContext)).thenReturn("test");
        assertEquals(mockRepository.getTrainCompanyName(1, mockContext), "test");
    }
}
