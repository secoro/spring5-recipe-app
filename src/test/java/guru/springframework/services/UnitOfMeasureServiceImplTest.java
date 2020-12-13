package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand uomToUomCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService uomService;

    @Mock
    UnitOfMeasureRepository uomRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        uomService = new UnitOfMeasureServiceImpl(uomRepository, uomToUomCommand);
    }

    @Test
    void getUomSet() {
        // given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);

        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);

        when(uomRepository.findAll()).thenReturn(unitOfMeasures);

        // when
        Set<UnitOfMeasureCommand> uomCommands = uomService.getUomSet();

        // then
        assertEquals(2, uomCommands.size());
        verify(uomRepository, times(1)).findAll();
    }
}