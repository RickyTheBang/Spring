package housekeeping.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MusicAspect {
   @DeclareParents(value = "housekeeping.DomesticServiceImpl",
         defaultImpl = housekeeping.aspects.MusicMakerImpl.class)
   public static MusicMaker mixin;   
}
