package challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class ReactiveExampleTest {

    @InjectMocks
    ReactiveExample reactiveExample;


    //pruebas con patron DDD
    @Test
    void sumaDePuntajes(){
        StepVerifier.create(reactiveExample.sumaDePuntajes())
                .expectNext(260 );
    }

    @Test
    void mayorPuntajeDeEstudiante(){
        StepVerifier.create(reactiveExample.mayorPuntajeDeEstudiante(35))
                .expectNext("{andres=35}")
                .verifyComplete();
    }

    @Test
    void totalDeAsisntenciasDeEstudiantesComMayorPuntajeDe(){
        StepVerifier.create(reactiveExample.totalDeAsisntenciasDeEstudiantesConMayorPuntajeDe(35))
                .expectNext(84)
                .verifyComplete();
    }

    @Test
    void elEstudianteTieneAsistenciasCorrectas(){
        StepVerifier.create(reactiveExample.elEstudianteTieneAsistenciasCorrectas(
                new Estudiante("raul", 30, List.of(5,2,1,4,5))))
                .expectNext(true)
                .verifyComplete();
    }

    @Test
    void promedioDePuntajesPorEstudiantes(){
        StepVerifier.create(reactiveExample.promedioDePuntajesPorEstudiantes())
                .expectNext(52)
                .verifyComplete();
    }

    @Test
    void losNombresDeEstudianteConPuntajeMayorA(){
        StepVerifier.create(reactiveExample.losNombresDeEstudianteConPuntajeMayorA(30))
                .expectNext("juan")
                .verifyComplete();
    }

    @Test
    void estudiantesAprovados(){
        StepVerifier.create(reactiveExample.estudiantesAprovados())
                .expectNext("juan" ,"pedro")
                .expectComplete()
                .verify();
    }


}