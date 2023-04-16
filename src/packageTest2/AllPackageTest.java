package packageTest2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    test.Test1.class,
    test.Test2.class,
    test.Test3.class,
    // Agregar aquí todas las clases de prueba que queremos incluir en esta suite
})
public class AllPackageTest {
    // No es necesario agregar ningún método aquí
}
