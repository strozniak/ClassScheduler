package com.pwr.mio.genetic.util;

import com.pwr.mio.genetic.model.Schedule;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Piotr on 07.12.13.
 */
public class RoulleteSelectionTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testChooseParents() throws Exception {
        Schedule fakeSchedule1 = mock(Schedule.class);
        Schedule fakeSchedule2 = mock(Schedule.class);

        when(fakeSchedule1.getGenomeValue()).thenReturn(10);
        when(fakeSchedule2.getGenomeValue()).thenReturn(2);

        List<Schedule> scheduleList = new LinkedList<Schedule>();
        scheduleList.add(fakeSchedule1);
        scheduleList.add(fakeSchedule2);

        RoulleteSelection roulleteSelection = new RoulleteSelection();





    }
}
