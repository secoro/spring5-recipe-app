package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    private final UnitOfMeasureRepository uomRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand uomTouomCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository uomRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand uomTouomCommand) {
        this.uomRepository = uomRepository;
        this.uomTouomCommand = uomTouomCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> getUomSet() {
        return StreamSupport.stream(uomRepository.findAll()
                .spliterator(), false)
                .map(uomTouomCommand::convert)
                .collect(Collectors.toSet());
    }
}
