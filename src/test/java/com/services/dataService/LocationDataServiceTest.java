package com.services.dataService;


import com.entities.Location;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

//to do
@RunWith(MockitoJUnitRunner.class)
public class LocationDataServiceTest {

    @InjectMocks
    private LocationDataService locationDataService;

    @Mock
    private LocationRepository locationRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    private Location createDatabaseWithParameter(){
        Location location = new Location();
        location.setName("test");
        location.setX(2.2);
        location.setY(5.2);
        location.setHead(true);
        return location;
    }


}
