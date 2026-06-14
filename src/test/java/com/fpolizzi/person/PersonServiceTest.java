package com.fpolizzi.person;

import com.fpolizzi.SortingOrder;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by fpolizzi on 6/14/26
 */
@SpringBootTest
class PersonServiceTest {

    @MockitoBean
    private FakePersonRepository fakePersonRepository;

    @MockitoBean
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    void canGetAllPeople() {

        // given
        SortingOrder sort = SortingOrder.ASC;

        // when
        personService.getPeople(sort);

        // then
        ArgumentCaptor<Sort> sortCapture =
                ArgumentCaptor.forClass(Sort.class);
        verify(personRepository).findAll(sortCapture.capture());

        assertThat(sortCapture.getValue())
                .isEqualTo(Sort.by(
                        Sort.Direction.valueOf(sort.name()),
                        "id"
                ));
    }
}