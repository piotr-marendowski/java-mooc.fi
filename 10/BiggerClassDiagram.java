import java.util.List;

public class BiggerClassDiagram {
    public interface IA {}

    public interface IB {}

    public interface IC {}

    class D implements IA {}

    class E {
        private List<C> cvalues;
    }

    class C extends B implements IC {
        private List<E> evalues;
    }

    class B extends A implements IB {}

    class A implements IA {}
}
