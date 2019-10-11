package housekeeping.aspect;

import housekeeping.services.MusicMaker;
import housekeeping.services.implementation.MusicMakerImplementation;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MusicAspect {


    @DeclareParents (value = "housekeeping.services.implementation.DomesticServiceImpl",
            defaultImpl = housekeeping.services.implementation.MusicMakerImplementation.class)
    public static MusicMaker mixin;





}
